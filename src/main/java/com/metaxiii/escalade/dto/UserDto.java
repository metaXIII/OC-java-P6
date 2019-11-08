package com.metaxiii.escalade.dto;

import com.metaxiii.escalade.validation.email.ValidEmail;
import com.metaxiii.escalade.validation.password.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@PasswordMatches
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
    @ValidEmail
    private String email;
    private String check_email;
    private List<String> role;
    private Set<String> errors;

    public UserDto() {
        List<String> list = new ArrayList<>();
        list.add("USER");
        this.role = list;
    }
}
