package com.example.course_isystem.service;

import com.example.course_isystem.dto.CourseDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.Course;
import com.example.course_isystem.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    public boolean create(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setStatus(true);
        course.setCreatedAt(LocalDateTime.now());
        convertEntityToDto(course, courseDto);
        courseRepository.save(course);
        return true;
    }

    public CourseDto get(Integer id) {
        Course course = getEntity(id);
        CourseDto courseDto = new CourseDto();
        convertDtoToEntity(courseDto, course);
        return courseDto;
    }

    public boolean update(Integer id, CourseDto courseDto) {
        Course course = getEntity(id);
        course.setUpdatedAt(LocalDateTime.now());
        convertEntityToDto(course, courseDto);
        courseRepository.save(course);
        return true;
    }

    public boolean delete(Integer id) {
        Course course = getEntity(id);
        course.setDeletedAt(LocalDateTime.now());
        courseRepository.save(course);
        return true;
    }

    Course getEntity(Integer id) {
        Optional<Course> optional = courseRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty())  {
            throw new CourseException("Course Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(CourseDto dto, Course entity) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
    }

    private void convertEntityToDto(Course entity, CourseDto dto) {
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
    }
}
