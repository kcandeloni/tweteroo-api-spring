package com.tweteroo.api.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
    List<TweetApp> tweets = repository.findAll(Sort.by(Direction.DESC,"id"));
    List<TweetApp> pageTweets = new ArrayList<>();
    if(page < 0) page = 0;
    int start = page * 5;
      for(int i = start; i < tweets.size() && i < start + 5; i++){
        pageTweets.add(tweets.get(i));
      }
    return tweets;
  }

  public List<TweetApp> findTweetsByNameUser(String name){
    return repository.findTweetsByName(name);
  }
}
