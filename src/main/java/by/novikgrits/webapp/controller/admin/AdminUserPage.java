package by.novikgrits.webapp.controller.admin;

import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminUserPage {
    private final UserService userService;

    public AdminUserPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String getUsers(Model model) {
        List<User> allUsers = userService.findAll();

        model.addAttribute("allUsers", allUsers);
        return "admin-user-id";
    }

    @PostMapping("/admin/users/delete/{id}")
    public String postDeleteUser(@PathVariable String id) {
        Integer userId = Integer.parseInt(id);
        userService.deleteUser(userId);

        return "redirect:/admin/users";
    }
}
