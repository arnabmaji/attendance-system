package io.github.arnabmaji19.attendancesystem.service;

import io.github.arnabmaji19.attendancesystem.entity.StudentDetail;
import io.github.arnabmaji19.attendancesystem.entity.User;
import io.github.arnabmaji19.attendancesystem.repository.StudentDetailRepository;
import io.github.arnabmaji19.attendancesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StudentDetailRepository studentDetailRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, StudentDetailRepository studentDetailRepository) {
        this.userRepository = userRepository;
        this.studentDetailRepository = studentDetailRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveStudent(User user, StudentDetail studentDetail) {
        userRepository.save(user);
        studentDetail.setId(user.getId());
        studentDetailRepository.save(studentDetail);
    }
}
