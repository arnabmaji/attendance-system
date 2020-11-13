package io.github.arnabmaji19.attendancesystem.dao;

import io.github.arnabmaji19.attendancesystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
