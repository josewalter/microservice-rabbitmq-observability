package com.msobservabilite.microservice_observabilite_user.controller;

import com.msobservabilite.microservice_observabilite_user.UserRecordDto;
import com.msobservabilite.microservice_observabilite_user.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private CityService cityService;

    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userSave = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveCity(userSave));
    }
}
