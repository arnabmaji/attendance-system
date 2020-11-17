package io.github.arnabmaji19.attendancesystem.model;

import java.util.List;

public class StudentUsernameList {
    private List<String> usernames;

    public StudentUsernameList() {
    }

    public StudentUsernameList(List<String> usernames) {
        this.usernames = usernames;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
