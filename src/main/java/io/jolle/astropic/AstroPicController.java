package io.jolle.astropic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AstroPicController {

    final AstroPicService astroPicService;

    public AstroPicController(AstroPicService astroPicService) { this.astroPicService = astroPicService; }

    @GetMapping("/astro-pic")
    public String displayAstroPic(Model model) {
        AstroPic astroPic = astroPicService.fetchAstroPicData();
        model.addAttribute(astroPic);
        return "astro";
    }
}
