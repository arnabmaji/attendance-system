package io.github.arnabmaji19.attendancesystem.restcontroller;

import io.github.arnabmaji19.attendancesystem.dao.CourseRepository;
import io.github.arnabmaji19.attendancesystem.dao.LectureRepository;
import io.github.arnabmaji19.attendancesystem.entity.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    private CourseRepository courseRepository;
    private LectureRepository lectureRepository;

    public HomeController(CourseRepository courseRepository, LectureRepository lectureRepository) {
        this.courseRepository = courseRepository;
        this.lectureRepository = lectureRepository;
    }

    @GetMapping("/")
    public String home() {
        var course = courseRepository.findById(1).get();
        for (var lecture : course.getLectures())
            logger.info(lecture.getDate().toString());
        Lecture lecture = new Lecture(Date.valueOf(LocalDate.now()));
        course.addLecture(lecture);
        lectureRepository.save(lecture);
        courseRepository.save(course);
        return "Attendance Management System";
    }
}
