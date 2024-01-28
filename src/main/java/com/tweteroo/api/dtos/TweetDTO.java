package com.tweteroo.api.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TweetDTO {

    @NotBlank(message = "Text cannot be blank")
    @Length(max = 280, message = "Max length of 280 characters")
    private String text;

    @NotNull(message = "userId cannot be null")
    private Long userId;
}
