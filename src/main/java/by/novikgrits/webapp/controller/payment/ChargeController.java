package by.novikgrits.webapp.controller.payment;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.payment.ChargeRequest;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.BidHistoryService;
import by.novikgrits.webapp.service.LotService;
import by.novikgrits.webapp.service.payment.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

@Controller
public class ChargeController {
    @Value("${mail.ru.password}")
    private String password;
    private final StripeService paymentsService;
    private final BidHistoryService bidHistoryService;
    private final AuctionsService auctionsService;
    private final LotService lotService;


    public ChargeController(StripeService paymentsService, BidHistoryService bidHistoryService, AuctionsService auctionsService, LotService lotService) {
        this.paymentsService = paymentsService;
        this.bidHistoryService = bidHistoryService;
        this.auctionsService = auctionsService;
        this.lotService = lotService;
    }

    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model, HttpSession session, HttpServletRequest request)
            throws StripeException, SQLException, MessagingException {
        chargeRequest.setDescription("Auction charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());

        Integer lotId = Integer.parseInt((String) session.getAttribute("foundAuctionId"));
        Double betPrice = Double.parseDouble((String) session.getAttribute("betPrice"));

        Auction auction = auctionsService.getAuctionByLotId(lotId);
        Lot lot = auction.getLot();
        lot.setCurrentPrice(lot.getCurrentPrice() + betPrice);
        lotService.updateLot(lot);

        String user = (String) session.getAttribute("current_user");
        BidHistory bidHistory = new BidHistory();
        bidHistory.setLotId(lotId);
        bidHistory.setBidderEmail(user);
        bidHistory.setPrice(betPrice);
        bidHistory.setBiddingDate(LocalDateTime.now().toString());
        bidHistoryService.addHistory(bidHistory);

        List<BidHistory> histories = bidHistoryService.findByLotId(lotId);
        if (histories.size() != 0) {
            String prevBidder = histories.get(histories.size() - 1).getBidderEmail();
            if (prevBidder != null && !Objects.equals(prevBidder, user)) {
                sendmail(prevBidder, lot);
            }
        }

        return "redirect:/active-auctions/lot/participate/" + lotId;
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "main";
    }

    private void sendmail(String sentTo, Lot lot) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("auction.trpo@mail.ru", password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("auction.trpo@mail.ru", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sentTo));
        msg.setSubject("You've been replaced");
        msg.setContent("You've been replaced in lot " + lot.getLotName() + "!\nCurrent price now is: " + lot.getCurrentPrice().toString(), "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }
}
