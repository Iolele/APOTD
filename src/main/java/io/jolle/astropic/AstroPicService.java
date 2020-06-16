package io.jolle.astropic;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroPicService {

    final
    RestTemplate restTemplate;

    public AstroPicService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    AstroPic fetchAstroPicData() {
        ResponseEntity<JsonNode> json = fetchJsonNodeResponseEntity();
        JsonNode jsonNodeAstroPic = json.getBody();


        AstroPic astroPic = new AstroPic();

        astroPic.setDate(jsonNodeAstroPic.get("date").textValue());
        astroPic.setExplanation(jsonNodeAstroPic.get("explanation").textValue());
        
        astroPic.setMediaType(jsonNodeAstroPic.get("media_type").textValue());
        astroPic.setServiceVersion(jsonNodeAstroPic.get("service_version").textValue());
        astroPic.setTitle(jsonNodeAstroPic.get("title").textValue());
        astroPic.setUrl(jsonNodeAstroPic.get("url").textValue());

        return astroPic;
    }

    private ResponseEntity<JsonNode> fetchJsonNodeResponseEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("api-nasa-host", "api.nasa.gov");
        httpHeaders.add("api-nasa-key", "Sx9sKSd80YoWm0xXR4Zgnb5bicZa1G2gxm04kW2Z");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        return restTemplate.exchange("https://api.nasa.gov/planetary/apod?api_key=Sx9sKSd80YoWm0xXR4Zgnb5bicZa1G2gxm04kW2Z", HttpMethod.GET, httpEntity, JsonNode.class);
    }
}
