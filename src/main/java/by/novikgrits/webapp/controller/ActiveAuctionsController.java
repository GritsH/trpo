package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActiveAuctionsController {
    private final LotService lotService;

    public ActiveAuctionsController(LotService lotService) {
        this.lotService = lotService;
    }

    @GetMapping("/active-auctions")
    public String getActiveAuctions(Model model) {
        List<Lot> activeLots = lotService.findAllActive();
        model.addAttribute("all_active_lots", activeLots);
        return "active_auctions";
    }
}
