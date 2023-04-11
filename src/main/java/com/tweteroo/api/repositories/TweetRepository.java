package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.TweetApp;

@Repository
public interface TweetRepository extends JpaRepository<TweetApp, Long> {
  @Query(value = "SELECT * FROM TWEET_APP WHERE USERNAME = ?1", nativeQuery = true)
  List<TweetApp> findTweetsByName(String name);
}