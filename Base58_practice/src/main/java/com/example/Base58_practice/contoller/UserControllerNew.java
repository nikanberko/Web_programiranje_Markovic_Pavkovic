package com.example.Base58_practice.contoller;

import com.example.Base58_practice.dto.UpdateUserDto;
import com.example.Base58_practice.dto.UserDto;
import com.example.Base58_practice.model.User;
import com.example.Base58_practice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserControllerNew {


    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping()
    public UserDto addUser(@RequestBody UserDto userDto){
        return this.userService.addUser(userDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PatchMapping("/{id}")
    public UserDto patchUser(@PathVariable("id") long id, @RequestBody UpdateUserDto updateUserDto){
        return this.userService.patchUser(id, updateUserDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") long id, @RequestBody UserDto UserDto){
        return this.userService.getUserById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) throws RuntimeException{
        this.userService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/page")
    public Page<UserDto> getUserPage( Pageable pageable){
        return userService.getUserPage(pageable);
    }


}
