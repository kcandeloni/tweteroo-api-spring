package com.tweteroo.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseTweets {
  public ResponseTweets(
    String username,
    String text,
    String avatar
  ){
    this.username = username;
    this.avatar = avatar;
    this.text = text;
  }

  private String username;

  private String avatar;

  private String text;
}
