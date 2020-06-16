package io.jolle.astropic;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstroPicRestController {

    final private AstroPicService astroPicService;

    public AstroPicRestController(AstroPicService astroPicService) {
        this.astroPicService = astroPicService;
    }

    @GetMapping("/pic")
    public String astroPicOfTheDay() {
        return astroPicService.fetchAstroPicData().toString();
    }

    @GetMapping(value = "/pic-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public AstroPic astroPicOfTheDayJson() {
        return astroPicService.fetchAstroPicData();
    }

}
