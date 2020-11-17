package io.github.arnabmaji19.attendancesystem.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class StudentUsernameRequest {

    @NotNull
    @Length(min = 5, max = 32)
    private String username;

    public StudentUsernameRequest() {
    }

    public StudentUsernameRequest(@Length(min = 5, max = 32) String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
