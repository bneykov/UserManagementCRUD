package com.personal.userManagement_app.web.controllers;

import com.personal.userManagement_app.model.dto.UserCreateDTO;
import com.personal.userManagement_app.model.dto.UserUpdateDTO;
import com.personal.userManagement_app.model.entity.UserEntity;
import com.personal.userManagement_app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserRestController {


    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody UserCreateDTO createDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        this.userService.createUser(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDTO);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> editProfile(@Valid @RequestBody UserUpdateDTO updateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        this.userService.update(updateDTO);
        return ResponseEntity.ok(updateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<UserEntity>> all(@RequestParam(value = "keyword", required = false) String keyword) {
        if (keyword == null || keyword.isBlank() || keyword.equals("null")) {
            List<UserEntity> users = this.userService.findAllSortedByLastNameAndDateOfBirth();
            return ResponseEntity.ok().body(users);
        }
        return ResponseEntity.ok().body(this.userService.searchAllSortedByLastNameAndDateOfBirth(keyword));

    }


    @GetMapping("/get/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        UserEntity user = this.userService.findById(id);
        return ResponseEntity.ok(user);
    }


}