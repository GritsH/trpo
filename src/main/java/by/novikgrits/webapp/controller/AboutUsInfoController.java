package by.novikgrits.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsInfoController {
    @GetMapping("/about-us")
    public String getAboutUs() {
        return "/about-us";
    }

    @GetMapping("/information")
    public String getInfo() {
        return "/information";
    }
}
