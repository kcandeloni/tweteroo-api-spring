package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.Dto.UserDTO;
import com.tweteroo.api.models.UserApp;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("/auth/sign-up")
  public String create(@RequestBody @Valid UserDTO req){
    service.create(new UserApp(req));
    return "OK";
  }
}
