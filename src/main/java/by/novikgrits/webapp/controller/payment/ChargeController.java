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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;

@Controller
public class ChargeController {
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
            throws StripeException, SQLException {
        chargeRequest.setDescription("Example charge");
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

        BidHistory bidHistory = new BidHistory();
        bidHistory.setLotId(lotId);
        bidHistory.setBidderEmail((String) session.getAttribute("current_user"));
        bidHistory.setPrice(betPrice);
        bidHistory.setBiddingDate(LocalDate.now());

        bidHistoryService.addHistory(bidHistory);

        return "redirect:/main";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "main";
    }
}
