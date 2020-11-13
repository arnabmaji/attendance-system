package io.github.arnabmaji19.attendancesystem.dao;

import io.github.arnabmaji19.attendancesystem.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {
}
