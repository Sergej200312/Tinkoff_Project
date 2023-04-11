package controller;

import DTO.LinkUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController


public class BotController {
    private final Map<String, LinkUpdateRequest> linkUpdateMap= new HashMap();
    @PostMapping("/updates")
    @ResponseStatus(HttpStatus.OK)
    public void sendUpdate(@RequestBody LinkUpdateRequest linkUpdate) {
        linkUpdateMap.put(linkUpdate.url(), linkUpdate);
    }
}


