package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {

    @GetMapping("/main")
    public String getMain(Model model) {
        List<String> allCategories = new ArrayList<>();
        ItemType.stream().forEach(i -> allCategories.add(i.getTypeDescription()));
        model.addAttribute("categories", allCategories);
        return "main";
    }
}
