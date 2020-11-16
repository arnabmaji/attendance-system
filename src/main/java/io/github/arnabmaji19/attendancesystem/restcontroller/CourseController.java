package io.github.arnabmaji19.attendancesystem.restcontroller;

import io.github.arnabmaji19.attendancesystem.entity.Course;
import io.github.arnabmaji19.attendancesystem.model.CourseDetails;
import io.github.arnabmaji19.attendancesystem.model.UserDetailsImpl;
import io.github.arnabmaji19.attendancesystem.service.CourseService;
import io.github.arnabmaji19.attendancesystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    private final CourseService courseService;
    private final UserService userService;

    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
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

}
