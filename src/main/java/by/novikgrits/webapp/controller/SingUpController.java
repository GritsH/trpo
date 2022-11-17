package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class SingUpController {
    private final UserService userService;

    public SingUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("new_user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpPost(@ModelAttribute User user, Model model) throws SQLException {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("user_exists", true);
            return "signup";
        }
        model.addAttribute("new_user", user);
        userService.addUser(user);
        return "login";
    }
}
