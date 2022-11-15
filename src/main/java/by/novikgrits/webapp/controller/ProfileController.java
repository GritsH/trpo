package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.ItemCategory;
import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.service.LotCategoryService;
import by.novikgrits.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;
    @Autowired
    private LotCategoryService lotCategoryService;
    @Autowired
    private HttpSession session;

    @GetMapping("/profile")
    public String getProfile(Model model) {
        List<ItemCategory> allCategories = lotCategoryService.getAllCategories();
        model.addAttribute("categories", allCategories);
        Optional<User> currentUser = userService.findByEmail(String.valueOf(session.getAttribute("current_user")));
        if (currentUser.isPresent()) {
            model.addAttribute("current_user", currentUser.get());
            return "profile";
        }
        return "redirect:/login";
    }

    @PostMapping("/profile")
    public String postProfile() {
        return "redirect:/profile";
    }
}
