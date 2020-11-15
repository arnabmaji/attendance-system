package io.github.arnabmaji19.attendancesystem.repository;

import io.github.arnabmaji19.attendancesystem.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}
