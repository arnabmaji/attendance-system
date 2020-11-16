package io.github.arnabmaji19.attendancesystem.service;

import io.github.arnabmaji19.attendancesystem.entity.StudentDetail;
import io.github.arnabmaji19.attendancesystem.entity.User;
import io.github.arnabmaji19.attendancesystem.repository.StudentDetailRepository;
import io.github.arnabmaji19.attendancesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void saveStudent(User user, StudentDetail studentDetail) {
        userRepository.save(user);
        studentDetail.setId(user.getId());
        studentDetailRepository.save(studentDetail);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
