package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.*;
import by.novikgrits.webapp.service.ItemCategoryService;
import by.novikgrits.webapp.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CreateLotController {
    private final ItemCategoryService itemCategoryService;
    private final ItemService itemService;

    public CreateLotController(ItemCategoryService itemCategoryService, ItemService itemService) {
        this.itemCategoryService = itemCategoryService;
        this.itemService = itemService;
    }

    @GetMapping("/create")
    public String getCreation(Model model) {
        List<ItemCategory> allCategories = itemCategoryService.getAllCategories();
        model.addAttribute("categories", allCategories);
        return "create-lot";
    }

    @PostMapping("/create")
    public String postCreation(HttpServletRequest request) {
        String selectId = request.getParameter("select_id");
        String categoryName = itemCategoryService.getById(Integer.parseInt(selectId));
        switch (categoryName) {
            case "PASSENGER CARS" -> {
                return "redirect:/create/car";
            }
            case "REAL ESTATE" -> {
                return "redirect:/create/real-estate";
            }
            case "JEWELRY" -> {
                return "redirect:/create/jewelry";
            }
            case "CLOTHES" -> {
                return "redirect:/create/clothes";
            }
            case "FURNITURE" -> {
                return "redirect:/create/furniture";
            }
            case "BUILDING EQUIPMENT" -> {
                return "redirect:/create/building-equipment";
            }
            case "SPORT EQUIPMENT" -> {
                return "redirect:/create/sport-equipment";
            }
            case "MEDICAL EQUIPMENT" -> {
                return "redirect:/create/medical-equipment";
            }
            case "OTHER" -> {
                return "redirect:/create/other";
            }
        }
        return "create-lot";
    }

    @GetMapping("/create/car")
    public String createCarLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newCar", new Car());
        return "car-page";
    }

    @PostMapping("/create/car")
    public String postCreateCar(@ModelAttribute Car newCar, @ModelAttribute Lot newLot) {
        itemService.register(newLot, newCar);
        return "redirect:/main";
    }

    @GetMapping("/create/real-estate")
    public String createEstateLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newRealEstate", new RealEstate());
        return "realestate-page";
    }

    @PostMapping("/create/real-estate")
    public String postCreateEstate(@ModelAttribute RealEstate newRealEstate, @ModelAttribute Lot newLot) {
        itemService.register(newLot, newRealEstate);
        return "redirect:/main";
    }

    @GetMapping("/create/jewelry")
    public String createJewelryLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newJewelry", new Jewelry());
        return "jewelry-page";
    }

    @PostMapping("/create/jewelry")
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Jewelry newJewelry) {
        itemService.register(newLot, newJewelry);
        return "redirect:/main";
    }

    @GetMapping("/create/clothes")
    public String createClothesLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newClothes", new Clothes());
        return "clothes-page";
    }

    @PostMapping("/create/clothes")
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Clothes newClothes) {
        itemService.register(newLot, newClothes);
        return "redirect:/main";
    }

    @GetMapping("/create/furniture")
    public String createFurnitureLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newFurniture", new Furniture());
        return "furniture-page";
    }

    @PostMapping("/create/furniture")
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Furniture newFurniture) {
        itemService.register(newLot, newFurniture);
        return "redirect:/main";
    }

    @GetMapping("/create/building-equipment")
    public String createBuildingEqLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newBuildingEquipment", new BuildingEquipment());
        return "building-equipment-page";
    }

    @PostMapping("/create/building-equipment")
    public String postBuildingEqJewelry(@ModelAttribute Lot newLot, @ModelAttribute BuildingEquipment newBuildingEquipment) {
        itemService.register(newLot, newBuildingEquipment);
        return "redirect:/main";
    }

    @GetMapping("/create/sport-equipment")
    public String createSportEqLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newSportEquipment", new SportEquipment());
        return "sport-equipment-page";
    }

    @PostMapping("/create/sport-equipment")
    public String postCreateSportEq(@ModelAttribute Lot newLot, @ModelAttribute SportEquipment newSportEquipment) {
        itemService.register(newLot, newSportEquipment);
        return "redirect:/main";
    }

    @GetMapping("/create/medical-equipment")
    public String createMedicalEqLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newMedicalEquipment", new MedicalEquipment());
        return "medical-equipment-page";
    }

    @PostMapping("/create/medical-equipment")
    public String postCreateMedicalEq(@ModelAttribute Lot newLot, @ModelAttribute MedicalEquipment newMedicalEquipment) {
        itemService.register(newLot, newMedicalEquipment);
        return "redirect:/main";
    }

    @GetMapping("/create/other")
    public String createOtherLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newOtherItem", new OtherItem());
        return "other-page";
    }

    @PostMapping("/create/other")
    public String postCreateOther(@ModelAttribute Lot newLot, @ModelAttribute OtherItem newOtherItem) {
        itemService.register(newLot, newOtherItem);
        return "redirect:/main";
    }
}
