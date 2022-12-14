package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.BidHistoryService;
import by.novikgrits.webapp.service.LotService;
import by.novikgrits.webapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
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
    public String getLot(@PathVariable String id, Model model, HttpSession session) throws SQLException {
        Integer lotId = Integer.parseInt(id);

        Auction auction = auctionsService.getAuctionByLotId(lotId);
        List<BidHistory> lotBidHistory = bidHistoryService.findByLotId(lotId);

        model.addAttribute("foundAuction", auction);
        model.addAttribute("lotBidHistory", lotBidHistory);
        session.setAttribute("betPrice", 0.0);

        return "lot-place-a-bet-page";
    }
}
