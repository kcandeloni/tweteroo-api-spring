package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.UserApp;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public void create(UserApp data){
    repository.save(data);
  }
}
