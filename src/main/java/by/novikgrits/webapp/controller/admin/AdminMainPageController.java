package by.novikgrits.webapp.controller.admin;

import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.service.BidHistoryService;
import by.novikgrits.webapp.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class AdminMainPageController {
    private final BidHistoryService bidHistoryService;
    private final LotService lotService;

    public AdminMainPageController(BidHistoryService bidHistoryService, LotService lotService) {
        this.bidHistoryService = bidHistoryService;
        this.lotService = lotService;
    }

    @GetMapping("/admin/main")
    public String getMainAdmin(Model model) {
        List<BidHistory> lastHistories = bidHistoryService.findLastHistoriesInLots();
        List<Lot> lots = new ArrayList<>();
        for (BidHistory bidHistory : lastHistories) {
            lots.add(lotService.findById(bidHistory.getLotId()).get());
        }

        model.addAttribute("lots", lots);
        model.addAttribute("bidHistories", lastHistories);
        return "/admin-main";
    }

    @PostMapping("/admin/main")
    public String sortHistories(Model model, @RequestParam(name = "sort_type") String sortBy) {
        List<BidHistory> histories = new ArrayList<>();
        if (Objects.equals(sortBy, "by name")) {
            histories = bidHistoryService.findSortedByBidderEmail();
        } else if (Objects.equals(sortBy, "by price")) {
            histories = bidHistoryService.findSortedByPrice();
        }
        model.addAttribute("bidHistories", histories);
        return "/admin-main";
    }
}
