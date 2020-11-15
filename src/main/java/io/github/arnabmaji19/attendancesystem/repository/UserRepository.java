package io.github.arnabmaji19.attendancesystem.repository;

import io.github.arnabmaji19.attendancesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
