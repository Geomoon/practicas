package com.tecazuay.practicas.controller;

import com.tecazuay.practicas.dto.RegisterRequest;
import com.tecazuay.practicas.dto.UserRequest;
import com.tecazuay.practicas.dto.UserResponse;
import com.tecazuay.practicas.exception.BadRequestException;
import com.tecazuay.practicas.exception.ResponseNotFoundException;
import com.tecazuay.practicas.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UsuarioRestController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = authService.login(userRequest);

        if (userResponse == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody RegisterRequest userRequest) {
        UserResponse userResponse = authService.signup(userRequest);

        if (userResponse == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
