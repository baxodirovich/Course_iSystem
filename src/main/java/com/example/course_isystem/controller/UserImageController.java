package com.example.course_isystem.controller;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.UserImageDto;
import com.example.course_isystem.service.UserImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user_image")
@AllArgsConstructor
public class UserImageController {

    private final UserImageService userImageService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserImageDto userImageDto){
        boolean result = userImageService.create(userImageDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        UserImageDto result = userImageService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid UserImageDto userImageDto){
        boolean result = userImageService.update(id, userImageDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = userImageService.delete(id);
        return ResponseEntity.ok(result);
    }
}
