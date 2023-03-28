package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/links")
public class LinkController {
    @Autowired
    private LinkService linkService;
    @GetMapping
    public ResponseEntity<ArrayList<LinkResponse>> getAllLinks() {
        ArrayList<LinkResponse> links = linkService.getAllLinks();
        return ResponseEntity.ok(links);
    }

    @PostMapping
    public ResponseEntity<?> addLink(@RequestBody LinkResponse link) {
        if (link == null || link.getUrl() == null || link.getName() == null) {
            return ResponseEntity.badRequest().build();
        }

        linkService.addLink(link);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/links")
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
