package io.github.arnabmaji19.attendancesystem.service;

import io.github.arnabmaji19.attendancesystem.entity.Role;
import io.github.arnabmaji19.attendancesystem.model.AppRole;

public interface RoleService {
    Role findRoleByName(AppRole role);
}
