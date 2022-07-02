package com.example.course_isystem.controller;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.GroupDto;
import com.example.course_isystem.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/group")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid GroupDto groupDto){
        boolean result = groupService.create(groupDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        ClassesDto result = groupService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid GroupDto groupDto){
        boolean result = groupService.update(id, groupDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = groupService.delete(id);
        return ResponseEntity.ok(result);
    }
}
