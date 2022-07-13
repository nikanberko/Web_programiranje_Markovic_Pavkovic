package com.example.Randomwordgenerator.service;
import com.example.Randomwordgenerator.dto.UpdateUserDto;
import com.example.Randomwordgenerator.dto.UserDto;
import com.example.Randomwordgenerator.model.User;
import com.example.Randomwordgenerator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDto getUserById(final long id) throws RuntimeException {
        return mapEntityToUserDto(this.repository.findById(id).orElseThrow(() -> new RuntimeException("user not found")));
    }

    public Page<UserDto> getUserPage(final Pageable pageable){
        return repository.findAll(pageable).map(this::mapEntityToUserDto);
    }


    public List<UserDto> getAllUsers() throws RuntimeException {

        List<UserDto> usersDto = new ArrayList<UserDto>();
        List<User> users = new ArrayList<User>();
        users = repository.findAll();

        for (User  user:users) {
            usersDto.add(mapEntityToUserDto(user));
        }
            return usersDto;
        }

    public UserDto patchUser(final long id, final UpdateUserDto updateUserDto){
        return mapEntityToUserDto(this.repository.save(mapUpdateUserDtoToEntity(this.repository.findById(id).orElseThrow(() -> new RuntimeException("user not found")), updateUserDto)));
    }

    public void deleteUser(final long id) throws RuntimeException{
        repository.delete(this.repository.findById(id).orElseThrow(() -> new RuntimeException("No user with such ID")));
    }


    public UserDto addUser(final UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return mapEntityToUserDto(this.repository.save(user));
    }


    private User mapUpdateUserDtoToEntity(final User userEntity, final UpdateUserDto updateUserDto) throws RuntimeException {
        updateUserDto.getOptionalUsername().ifPresent(userEntity::setUsername);
        updateUserDto.getOptionalEmail().ifPresent(userEntity::setEmail);

        return userEntity;
    }



    private UserDto mapEntityToUserDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());

        return userDto;

    }

}
