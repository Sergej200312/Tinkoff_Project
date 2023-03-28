package controller;

import DTO.UpdateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UpdatesController {
    @PostMapping("/updates")
    public ResponseEntity<String> sendUpdate(@RequestBody UpdateResponse request) {
        if (isValidRequest(request)) {
            return ResponseEntity.ok("Update sent successfully");
        }
        return ResponseEntity.badRequest().build();

    }

    private boolean isValidRequest(UpdateResponse request) {
        return true; // заглушка
    }
}
