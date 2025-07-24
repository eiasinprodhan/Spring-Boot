package com.emranhss.project.restcontroller;

import com.emranhss.project.entity.User;
import com.emranhss.project.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<Map<String, String>> createUser(
            @RequestPart(value = "user") String userJson,
            @RequestParam(value = "photo") MultipartFile file) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);
        try {
            userService.saveOrUpdate(user, file );
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User added successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (EntityNotFoundException e) {
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User added failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
