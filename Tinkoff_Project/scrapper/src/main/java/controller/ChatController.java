package controller;

import DTO.ChatResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ChatController {
    @Autowired
    private ChatService chatService;



    @PostMapping("/tg-chat/{id}")
    public ResponseEntity<?> registerChat(@RequestBody ChatResponse chat) {
        if (chat.getName() == null || chat.getUsers() == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }




        @DeleteMapping("/tg-chat/{id}")
        public ResponseEntity<?> deleteChat(@PathVariable Long id) {
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            boolean deleted = chatService.deleteChat(id);
            if (!deleted) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().build();
        }
    }

