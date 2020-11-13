package io.github.arnabmaji19.attendancesystem.dao;

import io.github.arnabmaji19.attendancesystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
