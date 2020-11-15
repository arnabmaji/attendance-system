package io.github.arnabmaji19.attendancesystem.repository;

import io.github.arnabmaji19.attendancesystem.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {
}
