package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.TweetApp;

@Repository
public interface TweetRepository extends JpaRepository<TweetApp, Long> {
  
}