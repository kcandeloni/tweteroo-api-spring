package com.tweteroo.api.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record HeaderUserNameDTO(@NotNull @NotBlank @Size(min = 3, max = 50) String username) {
  
}
