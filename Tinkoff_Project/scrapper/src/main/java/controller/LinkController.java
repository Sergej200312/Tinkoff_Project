package controller;

import DTO.LinkResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping(path = "/links",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class LinkController {

    @Autowired
    private LinkService linkService;
    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<LinkResponse>> getAllLinks() {
        ArrayList<LinkResponse> links = linkService.getAllLinks();
        return ResponseEntity.ok(links);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addLink(@RequestBody LinkResponse link) {
        if (link == null || link.getUrl() == null || link.getName() == null) {
            return ResponseEntity.badRequest().build();
        }

        linkService.addLink(link);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLink(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        boolean deleted = linkService.deleteLink(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
