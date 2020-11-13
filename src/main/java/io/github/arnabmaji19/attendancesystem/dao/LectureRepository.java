package io.github.arnabmaji19.attendancesystem.dao;

import io.github.arnabmaji19.attendancesystem.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}
