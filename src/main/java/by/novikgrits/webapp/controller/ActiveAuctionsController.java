package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
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
        List<String> allCategories = new ArrayList<>();
        ItemType.stream().forEach(i -> allCategories.add(i.getTypeDescription()));
        model.addAttribute("categories", allCategories);
        List<Lot> activeLots = lotService.findAllActive();
        Collections.sort(activeLots);
        List<Auction> auctions = auctionsService.getAllAuctions(activeLots);
        model.addAttribute("allActiveAuctions", auctions);
        return "active-auctions";
    }

    @GetMapping("/active-auctions/category/{categoryName}")
    public String getActiveLotsByCategory(@PathVariable String categoryName, Model model) {
        List<Lot> activeLots = lotService.findAllActive();
        Collections.sort(activeLots);
        ItemType itemType = ItemType.getByName(categoryName);
        List<Auction> foundAuctions = auctionsService.getByTypeAndStatus(itemType, activeLots.get(0).getStatusId());
        model.addAttribute("allActiveCategoryAuctions", foundAuctions);
        return "active-auctions";
    }
}
