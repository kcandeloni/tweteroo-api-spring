package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.Dto.TweetDTO;
import com.tweteroo.api.models.TweetApp;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TweetController {

  @Autowired
  private TweetService service;

  @PostMapping("/tweet")
  public String create(@RequestBody @Valid TweetDTO req){
    service.create(new TweetApp(req));
    return "OK";
  }
}
