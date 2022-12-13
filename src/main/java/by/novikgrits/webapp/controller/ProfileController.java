package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.service.AuctionsService;
import by.novikgrits.webapp.service.LotService;
import by.novikgrits.webapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController {
    private final UserService userService;
    private final HttpSession session;
    private final LotService lotService;
    private final AuctionsService auctionsService;

    public ProfileController(UserService userService, HttpSession session, LotService lotService, AuctionsService auctionsService) {
        this.userService = userService;
        this.session = session;
        this.lotService = lotService;
        this.auctionsService = auctionsService;
    }

    @GetMapping("/profile")
    public String getProfile(Model model) throws SQLException {
        List<String> allCategories = new ArrayList<>();
        ItemType.stream().forEach(i -> allCategories.add(i.getTypeDescription()));
        model.addAttribute("categories", allCategories);

        Optional<User> currentUser = userService.findByEmail(String.valueOf(session.getAttribute("current_user")));
        if (currentUser.isPresent()) {
            model.addAttribute("current_user", currentUser.get());
            List<Lot> usersLots = lotService.findByOwnerId(currentUser.get().getId());
            List<Auction> usersAuctions = auctionsService.getAllAuctions(usersLots);
            model.addAttribute("usersAuctions", usersAuctions);
            return "profile";
        }

        return "redirect:/login";
    }

    @PostMapping("/profile")
    public String postProfile() {
        return "redirect:/profile";
    }
}
