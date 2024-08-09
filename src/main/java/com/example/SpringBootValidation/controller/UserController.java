package com.example.SpringBootValidation.controller;

import com.example.SpringBootValidation.dto.UserDto;
import com.example.SpringBootValidation.entity.User;
import com.example.SpringBootValidation.serviece.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto){
        // convert UserDto to User entity


//
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User savedUser = userService.createUser(user);

//        // convert User entity to UserDto class
        UserDto userResponse = new UserDto();
        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());
//        // don't provide password to client
//        // userResponse.setPassword(savedUser.getPassword());
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
//        return new ResponseEntity<User>(userResponse, HttpStatus.CREATED);

//@PostMapping("users")
//	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
//		User savedUser = userService.createUser(user);
//		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
//	}
    }
}


//    @PostMapping
//    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {
//        User user = userService.saveUser(userDTO);
//        return new ResponseEntity<>("User is valid and has been saved with ID: " + user.getId(), HttpStatus.OK);
//    }
