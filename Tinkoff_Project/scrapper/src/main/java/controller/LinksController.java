package controller;

import DTO.ListLinkResponse;
import DTO.LinkResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import DTO.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/links")
public class LinksController {

    @PostMapping("/id")
    public ResponseEntity<ApiErrorResponse> addLink(@Valid @RequestBody AddLinkRequest request) {
        // Здесь должен быть код для добавления ссылки
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListLinkResponse.ListLinksResponse> listLinks() {
        // Здесь должен быть код для получения списка ссылок
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiErrorResponse> removeLink(@PathVariable long id) {
        // Здесь должен быть код для удаления ссылки
        return ResponseEntity.ok().build();
    }

    // Обработчик исключений для перехвата ошибок валидации
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        // Формируем список ошибок валидации
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        // Создаем объект ответа об ошибке
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                "Ошибка валидации",
                HttpStatus.BAD_REQUEST.toString(),
                ex.getClass(),
                ex.getMessage(),
                errors
        );

        // Возвращаем ответ с ошибкой
        return ResponseEntity.badRequest().body(errorResponse);
    }
}