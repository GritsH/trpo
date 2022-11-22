package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.BidHistoryService;
import by.novikgrits.webapp.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LotController {
    private final AuctionsService auctionsService;
    private final BidHistoryService bidHistoryService;
    private final LotService lotService;

    public LotController(AuctionsService auctionsService, BidHistoryService bidHistoryService, LotService lotService) {
        this.auctionsService = auctionsService;
        this.bidHistoryService = bidHistoryService;
        this.lotService = lotService;
    }

    @GetMapping("/active-auctions/lot/{id}/participate")
    public String getLot(@PathVariable String id, Model model) {
        Integer lotId = Integer.parseInt(id);
        Auction auction = auctionsService.getAuctionByLotId(lotId);
        List<BidHistory> lotBidHistory = bidHistoryService.findByLotId(lotId);

        model.addAttribute("foundAuction", auction);
        model.addAttribute("lotBidHistory", lotBidHistory);
        model.addAttribute("betPrice", 0.0);

        return "/lot";
    }

    @PostMapping("/active-auctions/lot/{id}/participate")
    public String postLot(@PathVariable String id, Model model) {
        Integer lotId = Integer.parseInt(id);
        Double betPrice = (Double) model.getAttribute("betPrice");

        Auction auction = auctionsService.getAuctionByLotId(lotId);
        Lot lot = auction.getLot();
        lot.setCurrentPrice(lot.getCurrentPrice() + betPrice);
        lotService.updateLot(lot);

        return "redirect:/lot";
    }
}
