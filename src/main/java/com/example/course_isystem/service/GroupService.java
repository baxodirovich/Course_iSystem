package com.example.course_isystem.service;

import com.example.course_isystem.dto.GroupDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.Group;
import com.example.course_isystem.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final CourseService courseService;
    private final GroupTypesService groupTypesService;
    public boolean create(GroupDto groupDto) {
        Group group = new Group();
        group.setId(groupDto.getId());
        group.setStatus(true);
        group.setCreatedAt(LocalDateTime.now());
        group.setCourse(courseService.getEntity(groupDto.getCourseId()));
        group.setGroupTypes(groupTypesService.getEntity(groupDto.getGroupTypesId()));
        convertEntityToDto(group, groupDto);
        groupRepository.save(group);
        return true;
    }

    public GroupDto get(Integer id) {
        Group group = getEntity(id);
        GroupDto groupDto = new GroupDto();
        groupDto.setCourse(group.getCourse());
        groupDto.setGroupTypes(group.getGroupTypes());
        convertDtoToEntity(groupDto, group);
        return groupDto;
    }

    public boolean update(Integer id, GroupDto groupDto) {
        Group group = getEntity(id);
        group.setUpdatedAt(LocalDateTime.now());
        group.setCourse(courseService.getEntity(groupDto.getCourseId()));
        group.setGroupTypes(groupTypesService.getEntity(groupDto.getGroupTypesId()));
        convertEntityToDto(group, groupDto);
        groupRepository.save(group);
        return true;
    }

    public boolean delete(Integer id) {
        Group group = getEntity(id);
        group.setDeletedAt(LocalDateTime.now());
        groupRepository.save(group);
        return true;
    }

    Group getEntity(Integer id) {
        Optional<Group> optional = groupRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new CourseException("Group Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(GroupDto dto, Group entity) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
    }

    private void convertEntityToDto(Group entity, GroupDto dto) {
        entity.setName(dto.getName());
    }
}
