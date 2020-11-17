package io.github.arnabmaji19.attendancesystem.service;

import io.github.arnabmaji19.attendancesystem.entity.Course;
import io.github.arnabmaji19.attendancesystem.model.LectureDetails;

import java.util.List;

public interface CourseService {
    void save(Course course);

    Course findById(int id);

    List<LectureDetails> getLectureDetailsList(Course course);
}
