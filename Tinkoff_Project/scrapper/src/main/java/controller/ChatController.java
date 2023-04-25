package controller;

import DTO.ChatRequest;
import DTO.ChatResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @PostMapping
    public ChatResponse createChat(@RequestBody ChatRequest chatRequest) {
        // создание чата в базе данных
        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setId(1L);
        chatResponse.setName(chatRequest.getName());
        chatResponse.setDescription(chatRequest.getDescription());
        chatResponse.setMembers(chatRequest.getMembers());
        return chatResponse;
    }

    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long chatId) {
        // удаление чата из базы данных
        return ResponseEntity.noContent().build();
    }
}