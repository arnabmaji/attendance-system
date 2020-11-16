package io.github.arnabmaji19.attendancesystem.service;

import io.github.arnabmaji19.attendancesystem.entity.StudentDetail;
import io.github.arnabmaji19.attendancesystem.entity.User;

public interface UserService {

    void save(User user);
    void saveStudent(User user, StudentDetail studentDetail);
    User findByUsername(String username);
}
