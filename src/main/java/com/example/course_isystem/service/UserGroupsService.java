package com.example.course_isystem.service;

import com.example.course_isystem.dto.UserGroupsDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.UserGroups;
import com.example.course_isystem.repository.UserGroupsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserGroupsService {
    private final UserGroupsRepository userGroupsRepository;
    private final GroupService groupService;
    private final UsersService usersService;
    private final TeacherService teacherService;
    public boolean create(UserGroupsDto userGroupsDto) {
        UserGroups userGroups = new UserGroups();
        userGroups.setId(userGroupsDto.getId());
        userGroups.setStatus(true);
        userGroups.setCreatedAt(LocalDateTime.now());
        userGroups.setGroup(groupService.getEntity(userGroupsDto.getGroupId()));
        userGroups.setUsers(usersService.getEntity(userGroupsDto.getUsersId()));
        userGroups.setTeacher(teacherService.getEntity(userGroupsDto.getTeacherId()));
        convertEntityToDto(userGroups, userGroupsDto);
        userGroupsRepository.save(userGroups);
        return true;
    }

    public UserGroupsDto get(Integer id) {
        UserGroups userGroups = getEntity(id);
        UserGroupsDto userGroupsDto = new UserGroupsDto();
        userGroupsDto.setGroup(userGroups.getGroup());
        userGroups.setUsers(userGroupsDto.getUsers());
        userGroups.setTeacher(userGroupsDto.getTeacher());
        convertDtoToEntity(userGroupsDto, userGroups);
        return userGroupsDto;
    }

    public boolean update(Integer id, UserGroupsDto userGroupsDto) {
        UserGroups userGroups = getEntity(id);
        userGroups.setUpdatedAt(LocalDateTime.now());
        userGroups.setGroup(groupService.getEntity(userGroupsDto.getGroupId()));
        userGroups.setUsers(usersService.getEntity(userGroupsDto.getUsersId()));
        userGroups.setTeacher(teacherService.getEntity(userGroupsDto.getTeacherId()));
        convertEntityToDto(userGroups, userGroupsDto);
        userGroupsRepository.save(userGroups);
        return true;
    }

    public boolean delete(Integer id) {
        UserGroups userGroups = getEntity(id);
        userGroups.setDeletedAt(LocalDateTime.now());
        userGroupsRepository.save(userGroups);
        return true;
    }

    public UserGroups getEntity(Integer userGroupsId) {
        Optional<UserGroups> optional = userGroupsRepository.findByIdAndDeletedAtIsNull(userGroupsId);
        if (optional.isEmpty()) {
            throw new CourseException("Users Groups Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(UserGroupsDto dto, UserGroups entity) {
        dto.setId(entity.getId());
    }

    private void convertEntityToDto(UserGroups entity, UserGroupsDto dto) {

    }
}
