package io.github.arnabmaji19.attendancesystem.service;

import io.github.arnabmaji19.attendancesystem.entity.Course;
import io.github.arnabmaji19.attendancesystem.entity.User;
import io.github.arnabmaji19.attendancesystem.model.LectureDetails;
import io.github.arnabmaji19.attendancesystem.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course findById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<LectureDetails> getLectureDetailsList(Course course) {
        List<LectureDetails> lectureDetailsList = new ArrayList<>();
        for (var lecture : course.getLectures()) {
            List<String> attendanceList = lecture.getAttendanceList()
                    .stream()
                    .map(User::getUsername)
                    .collect(Collectors.toList());
            lectureDetailsList.add(new LectureDetails(lecture.getId(), lecture.getDate(), attendanceList));
        }
        return lectureDetailsList;
    }
}
