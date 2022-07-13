package com.example.Randomwordgenerator.usercontroller;

import com.example.Randomwordgenerator.dto.UpdateUserDto;
import com.example.Randomwordgenerator.dto.UserDto;
import com.example.Randomwordgenerator.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @Operation(description = "Returns page of users", summary = "Returns page of users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/page")
    public Page<UserDto> getUserPage(final Pageable pageable){
        return userService.getUserPage(pageable);
    }

    @Operation(description = "Returns all users from repository", summary = "Returns all users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers() throws RuntimeException {
        return userService.getAllUsers();
    }

    @Operation(description = "Adds user to repository", summary = "Adds a user to repository")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping()
    public UserDto addUser(@RequestBody UserDto userDto) throws RuntimeException {
        return this.userService.addUser(userDto);
    }

    @Operation(description = "Updates specific information about a user", summary = "Updates user information")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PatchMapping("/{id}")
    public UserDto patchUser(@PathVariable("id")  long id, @RequestBody UpdateUserDto updateUserDto) throws RuntimeException {
        return this.userService.patchUser(id, updateUserDto);
    }

    @Operation(description = "Returns page of users", summary = "Returns page of users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") long id) throws RuntimeException {
        return this.userService.getUserById(id);
    }

    @Operation(description = "Deletes a specific user from repository", summary = "Deletes a specific user")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) throws RuntimeException{
        this.userService.deleteUser(id);
    }

}
