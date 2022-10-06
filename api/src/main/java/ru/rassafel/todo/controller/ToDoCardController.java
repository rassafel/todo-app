package ru.rassafel.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.rassafel.todo.controller.message.CreateToDoCardRequest;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = ToDoCardController.MAPPING)
public class ToDoCardController {
    public static final String MAPPING = "/todos";

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody CreateToDoCardRequest request) {
        return ResponseEntity.ok(Map.of("status", "card_created"));
    }

    @PostMapping("/{cardId}")
    public ResponseEntity<?> attachFileToCard(@PathVariable Long cardId, @RequestParam MultipartFile file) {
        return ResponseEntity.ok(Map.of("status", "file_attached"));
    }
}
