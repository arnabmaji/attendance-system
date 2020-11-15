package io.github.arnabmaji19.attendancesystem.restcontroller;

import io.github.arnabmaji19.attendancesystem.entity.User;
import io.github.arnabmaji19.attendancesystem.model.AppRole;
import io.github.arnabmaji19.attendancesystem.model.UserDetails;
import io.github.arnabmaji19.attendancesystem.service.RoleService;
import io.github.arnabmaji19.attendancesystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final UserService userService;
    private final RoleService roleService;

    public StudentController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@Valid @RequestBody UserDetails userDetails) {
        logger.info("Accepted User Details: " + userDetails);

        // Save the current user as a student
        User user = new User(
                userDetails.getUsername(),
                userDetails.getName(),
                userDetails.getPassword(),
                roleService.findRoleByName(AppRole.STUDENT)
        );
        userService.save(user);
        return ResponseEntity.ok().build();
    }
}
