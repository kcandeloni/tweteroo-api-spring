package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.Dto.TweetDTO;
import com.tweteroo.api.models.TweetApp;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweet")
public class TweetController {

  @Autowired
  private TweetService service;

  @PostMapping
  public String create(@RequestBody @Valid TweetDTO req){
    service.create(new TweetApp(req));
    return "OK";
  }

  @GetMapping
  public List<TweetApp> getAll(){
    return service.findAll();
  } 
}
