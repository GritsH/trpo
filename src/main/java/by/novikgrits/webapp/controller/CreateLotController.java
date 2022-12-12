package by.novikgrits.webapp.controller;

import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.LotPhoto;
import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.model.item.*;
import by.novikgrits.webapp.service.ItemService;
import by.novikgrits.webapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
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
    public String postCreateCar(@ModelAttribute Car newCar, @ModelAttribute Lot newLot, HttpSession session,
                                @RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/car";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());

        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        itemService.register(newLot, newCar, newPhoto);
        return "redirect:/main";
    }

    @GetMapping("/create/real-estate")
    public String createEstateLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newRealEstate", new RealEstate());
        return "realestate-page";
    }

    @PostMapping("/create/real-estate")
    public String postCreateEstate(@ModelAttribute RealEstate newRealEstate, @ModelAttribute Lot newLot, HttpSession session,
                                   @RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/real-estate";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();

        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        newLot.setOwnerId(currentUser.getId());
        itemService.register(newLot, newRealEstate, newPhoto);
        return "redirect:/main";
    }

    @GetMapping("/create/jewelry")
    public String createJewelryLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newJewelry", new Jewelry());
        return "jewelry-page";
    }

    @PostMapping("/create/jewelry")
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Jewelry newJewelry, HttpSession session,
                                    @RequestParam("jewelryPreciousStonesChoice") String hasStones,
                                    @RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/jewelry";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());

        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        newJewelry.setHasPreciousStones(Boolean.valueOf(hasStones));
        itemService.register(newLot, newJewelry, newPhoto);
        return "redirect:/main";
    }

    @GetMapping("/create/clothes")
    public String createClothesLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newClothes", new Clothes());
        return "clothes-page";
    }

    @PostMapping("/create/clothes")
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Clothes newClothes, HttpSession session,
                                    @RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/clothes";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());

        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        itemService.register(newLot, newClothes, newPhoto);
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
    public String postCreateJewelry(@ModelAttribute Lot newLot, @ModelAttribute Furniture newFurniture, HttpSession session,
                                    @RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/furniture";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();


        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        newLot.setOwnerId(currentUser.getId());
        itemService.register(newLot, newFurniture, newPhoto);
        return "redirect:/main";
    }

    @GetMapping("/create/building-equipment")
    public String createBuildingEqLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newBuildingEquipment", new BuildingEquipment());
        return "building-equipment-page";
    }

    @PostMapping("/create/building-equipment")
    public String postBuildingEqJewelry(@ModelAttribute Lot newLot, @ModelAttribute BuildingEquipment newBuildingEquipment,
                                        HttpSession session, @RequestParam("image") MultipartFile multipartFile,
                                        RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/building-equipment";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());

        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        itemService.register(newLot, newBuildingEquipment, newPhoto);
        return "redirect:/main";
    }

    @GetMapping("/create/sport-equipment")
    public String createSportEqLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newSportEquipment", new SportEquipment());
        return "sport-equipment-page";
    }

    @PostMapping("/create/sport-equipment")
    public String postCreateSportEq(@ModelAttribute Lot newLot, @ModelAttribute SportEquipment newSportEquipment,
                                    HttpSession session, @RequestParam("image") MultipartFile multipartFile,
                                    RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/sport-equipment";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());

        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        itemService.register(newLot, newSportEquipment, newPhoto);
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
    public String postCreateMedicalEq(@ModelAttribute Lot newLot, @ModelAttribute MedicalEquipment newMedicalEquipment,
                                      HttpSession session, @RequestParam("image") MultipartFile multipartFile,
                                      RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/medical-equipment";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());

        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        itemService.register(newLot, newMedicalEquipment, newPhoto);
        return "redirect:/main";
    }

    @GetMapping("/create/other")
    public String createOtherLot(Model model) {
        model.addAttribute("newLot", new Lot());
        model.addAttribute("newOtherItem", new OtherItem());
        return "other-page";
    }

    @PostMapping("/create/other")
    public String postCreateOther(@ModelAttribute Lot newLot, @ModelAttribute OtherItem newOtherItem, HttpSession session,
                                  @RequestParam("image") MultipartFile multipartFile,
                                  RedirectAttributes redirectAttributes) throws IOException, SQLException {
        if (hasBadWords(newLot.getLotName()) || hasBadWords(newLot.getBriefInfo())) {
            redirectAttributes.addFlashAttribute("hasBadWords", "Some fields contain bad words, please do not use them");
            return "redirect:/create/other";
        }

        String gmail = (String) session.getAttribute("current_user");
        currentUser = userService.findByEmail(gmail).get();
        newLot.setOwnerId(currentUser.getId());

        LotPhoto newPhoto = new LotPhoto();
        newPhoto.setPhoto(new SerialBlob(multipartFile.getBytes()));

        itemService.register(newLot, newOtherItem, newPhoto);
        return "redirect:/main";
    }

    private boolean hasBadWords(String input) {
        String buff = input;
        String inputForCheck = buff.toLowerCase();
        String[] badWords = {"fuck", "shit", "motherfucker", "fucker",
                "bitch", "sunnevabeach", "shithead", "dick", "slut",
                "whore", "pussy", "butthole", "fuuuuuuuuuuuck", "fuuck", "fuuuck", "fuuuuck", "fuuuuuck",
                "biitch", "biiitch", "biiiitch", "fuckk", "fuckkk", "ffuck", "fffuucckk", "ffuuuck", "fuuucckk",
                "diick", "diiick", "diiiick", "diiiiiick", "ddick", "dddick", "ddiick", "dicck", "dicckk", "diccck",
                "diicckk", "ddiicckk", "dddiiiccckkk", "dickk", "dickkk", "diicckk", "whooore", "whoore", "wwhhoorree",
                "whoree", "wwwhhhooorrreee", "whoooore", "whoooooooore", "whooooreee", "whhhoooorreee", "sluut", "sluuut",
                "sluuut", "sluuuuut", "sluuuuuuuuut", "ssluuuuut", "slllluuuuutttt", "ssssluuuut", "sssllluuuuuuutt",
                "puussy", "puuuussy", "pusy", "ppuussssyyy", "pppuuusssyyy", "puuuuuussy", "puuuusssyy", "pppuuusssyyy",
                "ppppuuuuussssyyyy", "pusyy", "pussyy", "ppusy", "pppuussy", "pppuusssyy", "puuuuuusssssyyyyyy",
                "puuuuuusssy", "fuucker", "ffuucker", "fuuucker", "fuuuucker", "fuuuuucker", "fuuuuuckeeer", "fuckeeeer",
                "fuckeer", "ffuucckkeerr", "fffuuuccckkkeeerrr", "fuuccker", "fucccker", "fucccckker",
                "fffuuuuuuuccckkkeeeeer", "fuuuuuuuuuuucker", "fuckeeeeeeeeeerrr", "fuckerrr", "fuckkkeerr", "fucckkeerr",
                "fuckerrrrrr", "fuuckeerr", "ffuuuuckeeeerr", "fffffuuuuucccccckeeeerr"};
        boolean hasBadWords = false;
        for (String word : badWords) {
            if (inputForCheck.contains(word)) {
                hasBadWords = true;
                break;
            }
        }
        return hasBadWords;
    }
}
