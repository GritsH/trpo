package by.novikgrits.webapp.controller.admin;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.BidHistoryService;
import by.novikgrits.webapp.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminMainPageController {
    private final AuctionsService auctionsService;
    private final BidHistoryService bidHistoryService;
    private final LotService lotService;

    public AdminMainPageController(AuctionsService auctionsService, BidHistoryService bidHistoryService, LotService lotService) {
        this.auctionsService = auctionsService;
        this.bidHistoryService = bidHistoryService;
        this.lotService = lotService;
    }

    @GetMapping("/admin/main")
    public String getMainAdmin(Model model){
        List<BidHistory> lastHistories = bidHistoryService.findLastHistoriesInLots();
        List<Lot> lots = new ArrayList<>();
        for (BidHistory bidHistory: lastHistories) {
            lots.add(lotService.findById(bidHistory.getLotId()).get());
        }

        model.addAttribute("lots", lots);
        model.addAttribute("bidHistories", lastHistories);
        return "/admin-main";
    }
}
