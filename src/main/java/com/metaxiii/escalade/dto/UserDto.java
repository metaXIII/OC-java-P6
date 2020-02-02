package com.metaxiii.escalade.dto;

import com.metaxiii.escalade.validation.email.ValidEmail;
import com.metaxiii.escalade.validation.password.PasswordMatches;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@PasswordMatches
@NoArgsConstructor
public class UserDto {
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    private String checkPassword;
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
    @NotNull
    @NotEmpty
    private String checkEmail;
    private String errors;
}
