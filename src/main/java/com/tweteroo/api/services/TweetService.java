package com.tweteroo.api.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

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

  public List<TweetApp> findAll(int page){
    return repository.findAll();
  }

  public List<TweetApp> findTweetsByNameUser(String name){
    return repository.findTweetsByName(name);
  }
}
