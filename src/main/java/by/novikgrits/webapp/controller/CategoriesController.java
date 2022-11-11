package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.LotCategory;
import by.novikgrits.webapp.service.LotCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriesController {
    @Autowired
    private LotCategoryService lotCategoryService;

    @GetMapping("/categories")
    public String getCategories(Model model){
        List<LotCategory> allCategories = lotCategoryService.getAllCategories();
        model.addAttribute("all_categories", allCategories);
        return "categories";
    }
}
