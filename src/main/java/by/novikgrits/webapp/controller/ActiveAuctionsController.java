package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class ActiveAuctionsController {
    private final LotService lotService;
    private final AuctionsService auctionsService;

    public ActiveAuctionsController(LotService lotService, AuctionsService auctionsService) {
        this.lotService = lotService;
        this.auctionsService = auctionsService;
    }

    @GetMapping("/active-auctions")
    public String getActiveAuctions(Model model) {
        List<Lot> activeLots = lotService.findAllActive();
        Collections.sort(activeLots);
        List<Auction> foundAuctions = auctionsService.getAuctions(activeLots);
        model.addAttribute("all_active_auctions", foundAuctions);
        return "active_auctions";
    }
}
