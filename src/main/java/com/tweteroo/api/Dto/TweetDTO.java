package com.tweteroo.api.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetDTO(

  @NotNull @NotBlank @Size(min = 3, max = 50) String username,
  
  @NotNull @NotBlank @Size(max = 256) String text) {
  
}
