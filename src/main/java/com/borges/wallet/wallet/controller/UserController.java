package com.borges.wallet.wallet.controller;

import com.borges.wallet.wallet.dto.UserDTO;
import com.borges.wallet.wallet.entity.User;
import com.borges.wallet.wallet.response.Response;
import com.borges.wallet.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> create(@Validated @RequestBody UserDTO dto, BindingResult resul) {

        Response<UserDTO> response = new Response<>();

        User user = service.save(this.convertDtoToEntity(dto));

        response.setData(this.convertEntityToDto(user));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private UserDTO convertEntityToDto(User u) {
        UserDTO dto = new UserDTO();
        dto.setName(u.getName());
        dto.setPassword(u.getPassword());
        dto.setEmail(u.getEmail());

        return dto;
    }

    private User convertDtoToEntity(UserDTO dto) {
        User u = new User();
        u.setName(dto.getName());
        u.setPassword(dto.getPassword());
        u.setEmail(dto.getEmail());

        return u;
    }
}
