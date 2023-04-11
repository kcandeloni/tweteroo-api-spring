package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  @ResponseStatus(value = HttpStatus.CREATED)
  public String create(@RequestBody @Valid TweetDTO req){
    service.create(new TweetApp(req));
    return "OK";
  }

  @GetMapping
  public List<TweetApp> getAll(@RequestParam("page") int page){
    return service.findAll(page);
  }

  @GetMapping("/{nameuser}")
  public List<TweetApp> getByNameUser(@PathVariable String nameuser){
    return service.findTweetsByNameUser(nameuser);
  } 
}
