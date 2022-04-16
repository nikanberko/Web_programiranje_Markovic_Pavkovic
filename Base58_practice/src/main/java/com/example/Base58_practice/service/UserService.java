package com.example.Base58_practice.service;

import com.example.Base58_practice.dto.UpdateUserDto;
import com.example.Base58_practice.dto.UserDto;
import com.example.Base58_practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.example.Base58_practice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDto getUserById(final long id) throws RuntimeException {
        return mapEntityToUserDto(this.repository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public Page<UserDto> getUserPage(final Pageable pageable) throws RuntimeException {
        return repository.findAll(pageable).map(this::mapEntityToUserDto);
    }

    public List<UserDto> getAllUsers() throws RuntimeException{
        List<UserDto> usersDto = new ArrayList<UserDto>();
             repository.findAll().forEach(user -> {
                 usersDto.add(mapEntityToUserDto(user));});

        return usersDto;
    }

    public UserDto patchUser(final long id, final UpdateUserDto updateUserDto) throws RuntimeException {
        return mapEntityToUserDto(this.repository.save(mapUpdateUserDtoToEntity(this.repository.findById(id).orElseThrow(() -> new RuntimeException("user not found")), updateUserDto)));
    }

    public void deleteUser(final long id) throws RuntimeException{
        repository.delete(this.repository.findById(id).orElseThrow(() -> new RuntimeException("No user with such ID")));
    }

    public UserDto addUser(final UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());

        user.setEmail(userDto.getEmail());


        return mapEntityToUserDto(this.repository.save(user));


    }

    private User mapUpdateUserDtoToEntity(final User userEntity, final UpdateUserDto updateUserDto) throws RuntimeException {
        updateUserDto.getOptionalFirstName().ifPresent(userEntity::setFirstName);
        updateUserDto.getOptionalEmail().ifPresent(userEntity::setEmail);
        return userEntity;
    }



    private UserDto mapEntityToUserDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setEmail(user.getEmail());


        return userDto;

    }

}
