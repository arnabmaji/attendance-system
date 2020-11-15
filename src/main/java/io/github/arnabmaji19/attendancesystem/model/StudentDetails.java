package io.github.arnabmaji19.attendancesystem.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class StudentDetails {

    @NotNull
    @Length(min = 5, max = 50)
    private String username;

    @NotNull
    @Length(min = 5, max = 100)
    private String name;

    @NotNull
    @Length(min = 5, max = 32)
    private String password;

    @NotNull
    @Length(min = 10, max = 20)
    private String parentPhone;

    public StudentDetails() {
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

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", parentPhone='" + parentPhone + '\'' +
                '}';
    }
}
