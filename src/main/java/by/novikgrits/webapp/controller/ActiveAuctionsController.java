package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.ItemCategory;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.ItemCategoryService;
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
    private final ItemCategoryService itemCategoryService;
    private final AuctionsService auctionsService;

    public ActiveAuctionsController(LotService lotService, ItemCategoryService itemCategoryService, AuctionsService auctionsService) {
        this.lotService = lotService;
        this.itemCategoryService = itemCategoryService;
        this.auctionsService = auctionsService;
    }

    @GetMapping("/active-auctions")
    public String getActiveAuctions(Model model) {
        List<ItemCategory> allCategories = itemCategoryService.getAllCategories();
        model.addAttribute("categories", allCategories);
        List<Lot> activeLots = lotService.findAllActive();
        Collections.sort(activeLots);
        List<Auction> auctions = auctionsService.getAllAuctions(activeLots);
        model.addAttribute("all_active_auctions", auctions);
        return "active_auctions";
    }

    @GetMapping("/active-auctions/category/{id}")
    public String getActiveLotsByCategory(@PathVariable String id, Model model) {
        List<Lot> activeLots = lotService.findAllActive();
        Collections.sort(activeLots);
        String categoryName = itemCategoryService.getById(Integer.parseInt(id));
        List<Auction> foundAuctions = switch (categoryName) {
            case "PASSENGER CARS" -> auctionsService.getCarAuctions(activeLots);
            case "REAL ESTATE" -> auctionsService.getEstateAuctions(activeLots);
            case "JEWELRY" -> auctionsService.getJewelryAuctions(activeLots);
            case "CLOTHES" -> auctionsService.getClothesAuctions(activeLots);
            case "FURNITURE" -> auctionsService.getFurnitureAuctions(activeLots);
            case "BUILDING EQUIPMENT" -> auctionsService.getBuildingEquipmentAuctions(activeLots);
            case "SPORT EQUIPMENT" -> auctionsService.getSportEquipmentAuctions(activeLots);
            case "MEDICAL EQUIPMENT" -> auctionsService.getMedicalEquipmentAuctions(activeLots);
            case "OTHER" -> auctionsService.getOtherAuctions(activeLots);
            default -> new ArrayList<>();
        };
        model.addAttribute("all_active_auctions", foundAuctions);
        return "active_auctions";
    }
}
