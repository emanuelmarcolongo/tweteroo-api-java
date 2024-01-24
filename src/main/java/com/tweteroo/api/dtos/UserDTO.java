package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "You must insert an username")
    @Size(max = 100)
    private String username;

    @NotBlank(message = "You must insert an avatar Url")
    private String avatar;
}
