package com.example.course_isystem.service;

import com.example.course_isystem.dto.UsersDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.Users;
import com.example.course_isystem.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {
    private UsersRepository usersRepository;
    private UserTypesService userTypesService;

    public boolean create(UsersDto usersDto) {
        Users users = new Users();
        users.setStatus(true);
        users.setCreatedAt(LocalDateTime.now());
        users.setUserTypes(userTypesService.getEntity(usersDto.getUserTypesId()));
        users.setGender(usersDto.getGender());
        convertEntityToDto(users, usersDto);
        usersRepository.save(users);
        return true;
    }

    public UsersDto get(Integer id) {
        Users users = getEntity(id);
        UsersDto usersDto = new UsersDto();
        usersDto.setUserTypes(users.getUserTypes());
        convertDtoToEntity(usersDto, users);
        return usersDto;
    }

    public boolean update(Integer id, UsersDto usersDto) {
        Users users = getEntity(id);
        users.setUpdatedAt(LocalDateTime.now());
        users.setUserTypes(userTypesService.getEntity(usersDto.getUserTypesId()));
        convertEntityToDto(users, usersDto);
        usersRepository.save(users);
        return true;
    }

    public boolean delete(Integer id) {
        Users users = getEntity(id);
        users.setDeletedAt(LocalDateTime.now());
        usersRepository.save(users);
        return true;
    }

    public Users getEntity(Integer id){
        Optional<Users> optional = usersRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new CourseException("Users Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(UsersDto dto, Users entity) {
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setGender(entity.getGender());
        dto.setAddressFirst(entity.getAddressFirst());
        dto.setAddressSecond(entity.getAddressSecond());
        dto.setPassword(entity.getPassword());
        //dto.setUserImageId(entity.getUserImageId());
    }

    private void convertEntityToDto(Users entity, UsersDto dto) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setGender(dto.getGender());
        entity.setPassword(dto.getPassword());
        entity.setAddressFirst(dto.getAddressFirst());
        entity.setAddressSecond(dto.getAddressSecond());
        //entity.setUserImageId(dto.getUserImageId());
    }
}
