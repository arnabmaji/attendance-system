package io.github.arnabmaji19.attendancesystem.service;

import io.github.arnabmaji19.attendancesystem.entity.Course;

public interface CourseService {
    void save(Course course);
    Course findById(int id);
}
