package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.service.AuctionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DetailedLotController {
    private final AuctionsService auctionsService;

    public DetailedLotController(AuctionsService auctionsService) {
        this.auctionsService = auctionsService;
    }

    @GetMapping("/active-auctions/lot/details/{id}")
    public String getLot(@PathVariable String id, Model model) throws SQLException {
        List<String> allCategories = new ArrayList<>();
        ItemType.stream().forEach(i -> allCategories.add(i.getTypeDescription()));
        model.addAttribute("categories", allCategories);

        Auction auction = auctionsService.getAuctionByLotId(Integer.parseInt(id));
        model.addAttribute("foundAuction", auction);
        return "/lot-details";
    }
}
