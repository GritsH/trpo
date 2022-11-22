package by.novikgrits.webapp.controller.admin;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.ItemService;
import by.novikgrits.webapp.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminAuctionsController {
    private final AuctionsService auctionsService;
    private final ItemService itemService;
    private final LotService lotService;

    public AdminAuctionsController(AuctionsService auctionsService, ItemService itemService, LotService lotService) {
        this.auctionsService = auctionsService;
        this.itemService = itemService;
        this.lotService = lotService;
    }

    @GetMapping("/admin/lots")
    public String getAdminLots(Model model){
        List<Lot> activeLots = lotService.findAllActive();
        List<Auction> auctions = auctionsService.getAllAuctions(activeLots);

        model.addAttribute("activeAuctions", auctions);
        return "/admin_lot_id";
    }

    @PostMapping("/admin/lots/delete/{id}")
    public String postDeleteLot(@PathVariable String id){
        Lot lot = lotService.findById(Integer.parseInt(id)).get();
        itemService.removeItem(lot);
        return "redirect:/admin/lots";
    }

}
