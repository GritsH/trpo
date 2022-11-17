package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.ItemCategory;
import by.novikgrits.webapp.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {
    private final ItemCategoryService itemCategoryService;

    public MainPageController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @GetMapping("/main")
    public String getMain(Model model) {
        List<ItemCategory> allCategories = itemCategoryService.getAllCategories();
        model.addAttribute("categories", allCategories);
        return "main";
    }
}
