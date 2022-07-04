package com.example.course_isystem.controller;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.UserGroupsDto;
import com.example.course_isystem.service.UserGroupsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user_groups")
@AllArgsConstructor
public class UserGroupsController {
    private final UserGroupsService userGroupsService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserGroupsDto userGroupsDto){
        boolean result = userGroupsService.create(userGroupsDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        UserGroupsDto result = userGroupsService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid UserGroupsDto userGroupsDto){
        boolean result = userGroupsService.update(id, userGroupsDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = userGroupsService.delete(id);
        return ResponseEntity.ok(result);
    }
}
