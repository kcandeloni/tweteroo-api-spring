package com.tweteroo.api.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.ResponseList;
import com.tweteroo.api.models.ResponseTweets;
import com.tweteroo.api.models.TweetApp;
import com.tweteroo.api.models.UserApp;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {
 
  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private UserRepository userRepository;


  public void create(TweetApp data){
    tweetRepository.save(data);
  }

  public ResponseList findAll(int page){
    List<TweetApp> tweets = tweetRepository.findAll(Sort.by(Direction.DESC,"id"));
    List<ResponseTweets> pageTweets = new ArrayList<>();
    List<UserApp> users = userRepository.findAll();
    if(page < 0) page = 0;
    int start = page * 5;
    String avatar = "";
    for(int i = start; i < tweets.size() && i < start + 5; i++){
      for(int j = 0; j < users.size(); j++){
        if(users.get(j).getUsername().equals(tweets.get(i).getUsername())){
          avatar = users.get(j).getAvatar();
          break;
        }
      }
      pageTweets.add(new ResponseTweets(
        tweets.get(i).getUsername(),
        tweets.get(i).getText(),
        avatar));
    }
    return new ResponseList(pageTweets);
  }

  public List<ResponseTweets> findTweetsByNameUser(String name){
    List<TweetApp> tweets = tweetRepository.findTweetsByName(name);
    List<ResponseTweets> pageTweets = new ArrayList<>();
    List<UserApp> users = userRepository.findAll();
    String avatar = "";
    for(int i = 0; i < users.size(); i++){
      if(users.get(i).getUsername().equals(name)){
        avatar = users.get(i).getAvatar();
        break;
      }
    }
    for(int i = 0; i < tweets.size(); i++){
      pageTweets.add(new ResponseTweets(
        tweets.get(i).getUsername(),
        tweets.get(i).getText(),
        avatar));
    }
    return pageTweets;
  }
}
