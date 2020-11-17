package io.github.arnabmaji19.attendancesystem.restcontroller;

import io.github.arnabmaji19.attendancesystem.entity.Course;
import io.github.arnabmaji19.attendancesystem.entity.Lecture;
import io.github.arnabmaji19.attendancesystem.entity.User;
import io.github.arnabmaji19.attendancesystem.model.*;
import io.github.arnabmaji19.attendancesystem.service.CourseService;
import io.github.arnabmaji19.attendancesystem.service.LectureService;
import io.github.arnabmaji19.attendancesystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    private final CourseService courseService;
    private final UserService userService;
    private final LectureService lectureService;

    public CourseController(CourseService courseService, UserService userService, LectureService lectureService) {
        this.courseService = courseService;
        this.userService = userService;
        this.lectureService = lectureService;
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody CourseDetails courseDetails) {

        logger.info("Title: " + courseDetails.getTitle());

        // Retrieve currently logged in user
        var userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        var user = userService.findByUsername(userDetails.getUsername());

        Course course = new Course(courseDetails.getTitle(), user);
        courseService.save(course);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{courseId}/enrollments/")
    public ResponseEntity<?> enroll(@PathVariable int courseId,
                                    @Valid @RequestBody StudentUsernameRequest studentUsernameRequest) {
        Course course = courseService.findById(courseId);
        if (course == null)
            return ResponseEntity.badRequest().body(new ResponseMessage("Course not found."));

        User user = userService.findByUsername(studentUsernameRequest.getUsername());
        if (user == null)
            return ResponseEntity.badRequest().body(new ResponseMessage("Username not found"));

        course.enrollStudent(user);
        courseService.save(course);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{courseId}/enrollments/")
    public ResponseEntity<?> getEnrollments(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);
        if (course == null)
            return ResponseEntity.badRequest().body(new ResponseMessage("Course not found."));

        List<String> list = course
                .getEnrolledStudents()
                .stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new StudentUsernameList(list));
    }

    @PostMapping("/{courseId}/lectures/")
    public ResponseEntity<?> createLectures(@PathVariable int courseId,
                                            @Valid @RequestBody StudentUsernameList list) {

        Course course = courseService.findById(courseId);
        if (course == null)
            return ResponseEntity.badRequest().body(new ResponseMessage("Course not found."));

        List<User> userList = list.getUsernames()
                .stream()
                .map(userService::findByUsername)
                .collect(Collectors.toList());
        Lecture lecture = new Lecture(Date.valueOf(LocalDate.now()), userList);
        course.addLecture(lecture);

        lectureService.save(lecture);
        courseService.save(course);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{courseId}/lectures/")
    public ResponseEntity<?> getLectures(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);
        if (course == null)
            return ResponseEntity.badRequest().body(new ResponseMessage("Course not found."));

        var list = courseService.getLectureDetailsList(course);
        return ResponseEntity.ok(list);
    }

}
