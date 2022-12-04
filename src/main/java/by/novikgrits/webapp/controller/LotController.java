package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.BidHistoryService;
import by.novikgrits.webapp.service.LotService;
import by.novikgrits.webapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class LotController {
    private final AuctionsService auctionsService;
    private final BidHistoryService bidHistoryService;
    private final LotService lotService;
    private final UserService userService;

    public LotController(AuctionsService auctionsService, BidHistoryService bidHistoryService, LotService lotService, UserService userService) {
        this.auctionsService = auctionsService;
        this.bidHistoryService = bidHistoryService;
        this.lotService = lotService;
        this.userService = userService;
    }

    @GetMapping("/active-auctions/lot/participate/{id}")
    public String getLot(@PathVariable String id, Model model) {
        Integer lotId = Integer.parseInt(id);
        Auction auction = auctionsService.getAuctionByLotId(lotId);
        List<BidHistory> lotBidHistory = bidHistoryService.findByLotId(lotId);

        model.addAttribute("foundAuction", auction);
        model.addAttribute("lotBidHistory", lotBidHistory);

        return "lot-place-a-bet-page";
    }

    @PostMapping("/active-auctions/lot/participate/{id}")
    public String postLot(@PathVariable String id, Model model, HttpServletRequest request, HttpSession session) {
        Integer lotId = Integer.parseInt(id);
        Double betPrice = Double.parseDouble(request.getParameter("betPrice"));

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

        return "redirect:/active-auctions/lot/participate/{id}";
    }
}
