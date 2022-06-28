package com.example.course_isystem.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<?> exception(CourseException c){
        return ResponseEntity.badRequest().body(c.getMessage());
    }
}
