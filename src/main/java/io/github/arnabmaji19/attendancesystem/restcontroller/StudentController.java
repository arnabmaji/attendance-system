package io.github.arnabmaji19.attendancesystem.restcontroller;

import io.github.arnabmaji19.attendancesystem.entity.StudentDetail;
import io.github.arnabmaji19.attendancesystem.entity.User;
import io.github.arnabmaji19.attendancesystem.model.AppRole;
import io.github.arnabmaji19.attendancesystem.model.ResponseMessage;
import io.github.arnabmaji19.attendancesystem.model.StudentDetails;
import io.github.arnabmaji19.attendancesystem.service.RoleService;
import io.github.arnabmaji19.attendancesystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public StudentController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@Valid @RequestBody StudentDetails studentDetails) {
        logger.info("Accepted User Details: " + studentDetails);

        User user = userService.findByUsername(studentDetails.getUsername());
        if (user != null)
            return ResponseEntity.badRequest().body(new ResponseMessage("username already registered."));

        // Save the current user as a student
        user = new User(
                studentDetails.getUsername(),
                studentDetails.getName(),
                passwordEncoder.encode(studentDetails.getPassword()),
                roleService.findRoleByName(AppRole.STUDENT)
        );
        StudentDetail studentDetail = new StudentDetail(user.getId(), studentDetails.getParentPhone());
        userService.saveStudent(user, studentDetail);
        return ResponseEntity.ok().build();
    }
}
