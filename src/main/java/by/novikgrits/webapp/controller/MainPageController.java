package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.ItemCategory;
import by.novikgrits.webapp.service.LotCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {
    @Autowired
    private LotCategoryService lotCategoryService;

    @GetMapping("/main")
    public String getMain(Model model) {
        List<ItemCategory> allCategories = lotCategoryService.getAllCategories();
        model.addAttribute("categories", allCategories);
        return "main";
    }
}
