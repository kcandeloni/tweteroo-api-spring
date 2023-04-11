package com.tweteroo.api.models;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseList {
  public ResponseList(
    List<ResponseTweets> list
  ){
    this.content = list;
  }

  private List<ResponseTweets> content;

}
