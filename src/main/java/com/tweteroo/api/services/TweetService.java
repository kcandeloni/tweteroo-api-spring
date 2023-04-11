package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.TweetApp;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {
 
  @Autowired
  private TweetRepository repository;


  public void create(TweetApp data){
    repository.save(data);
  }
}
