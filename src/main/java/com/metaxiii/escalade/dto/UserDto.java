package com.metaxiii.escalade.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    private String check_password;
    @NotNull
    @NotEmpty
    private String email;
    private String check_email;
    private int role;

    public UserDto() {
        this.role = 1;
    }
}
