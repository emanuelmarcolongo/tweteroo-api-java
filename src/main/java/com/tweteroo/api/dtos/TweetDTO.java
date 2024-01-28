package com.tweteroo.api.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TweetDTO {

    @NotBlank
    @Length(max = 280)
    private String text;

    @NotNull
    private Long userId;
}
