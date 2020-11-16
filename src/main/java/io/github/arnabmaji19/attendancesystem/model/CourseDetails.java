package io.github.arnabmaji19.attendancesystem.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CourseDetails {

    @NotNull
    @Length(min = 4, max = 128)
    private String title;

    public CourseDetails() {
    }

    public CourseDetails(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
