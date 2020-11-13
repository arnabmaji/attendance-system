package io.github.arnabmaji19.attendancesystem.dao;

import io.github.arnabmaji19.attendancesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
