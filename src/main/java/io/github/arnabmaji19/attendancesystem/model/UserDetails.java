package io.github.arnabmaji19.attendancesystem.model;

import org.hibernate.validator.constraints.Length;

public class UserDetails {

    @Length(min = 5, max = 50)
    private String username;

    @Length(min = 5, max = 100)
    private String name;

    @Length(min = 5, max = 32)
    private String password;

    public UserDetails() {
    }

    public UserDetails(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
