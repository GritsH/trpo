package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.model.item.*;
import by.novikgrits.webapp.service.ItemService;
import by.novikgrits.webapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateLotController {
    private final ItemService itemService;
    private final UserService userService;
    private User currentUser;

    public CreateLotController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String getCreation(Model model) {
        List<String> allCategories = new ArrayList<>();
        ItemType.stream().forEach(i -> allCategories.add(i.getTypeDescription()));
        model.addAttribute("categories", allCategories);
        return "create-lot";
    }

    @GetMapping("/create/car")
    public String createCarLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newCar", new Car());
        return "car-page";
    }

    @PostMapping("/create/car")
    public String postCreateCar(@ModelAttribute Car newCar, @ModelAttribute Lot newLot, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
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
    public String postCreateEstate(@ModelAttribute RealEstate newRealEstate, @ModelAttribute Lot newLot, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
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
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Jewelry newJewelry, HttpServletRequest request, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
        String hasStones = request.getParameter("jewelryPreciousStonesChoice");
        newJewelry.setHasPreciousStones(Boolean.valueOf(hasStones));
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
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Clothes newClothes, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
        itemService.register(newLot, newClothes);
        return "redirect:/main";
    }

    @GetMapping("/create/furniture")
    public String createFurnitureLot(Model model) {
        model.addAttribute("furnitureTypes", FurnitureType.getAll());

        model.addAttribute("newLot", new Lot());
        model.addAttribute("newFurniture", new Furniture());
        return "furniture-page";
    }

    @PostMapping("/create/furniture")
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Furniture newFurniture, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
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
    public String postBuildingEqJewelry(@ModelAttribute Lot newLot, @ModelAttribute BuildingEquipment newBuildingEquipment, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
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
    public String postCreateSportEq(@ModelAttribute Lot newLot, @ModelAttribute SportEquipment newSportEquipment, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
        itemService.register(newLot, newSportEquipment);
        return "redirect:/main";
    }

    @GetMapping("/create/medical-equipment")
    public String createMedicalEqLot(Model model) {
        model.addAttribute("medicalSpecialities", MedicalSpeciality.getAll());

        model.addAttribute("newLot", new Lot());
        model.addAttribute("newMedicalEquipment", new MedicalEquipment());
        return "medical-equipment-page";
    }

    @PostMapping("/create/medical-equipment")
    public String postCreateMedicalEq(@ModelAttribute Lot newLot, @ModelAttribute MedicalEquipment newMedicalEquipment, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
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
    public String postCreateOther(@ModelAttribute Lot newLot, @ModelAttribute OtherItem newOtherItem, HttpSession session) {
        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());
        itemService.register(newLot, newOtherItem);
        return "redirect:/main";
    }
}
