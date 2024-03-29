package io.github.arnabmaji19.attendancesystem.repository;

import io.github.arnabmaji19.attendancesystem.entity.Role;
import io.github.arnabmaji19.attendancesystem.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByName(AppRole role);
}
