package io.github.arnabmaji19.attendancesystem.restcontroller;

import io.github.arnabmaji19.attendancesystem.entity.User;
import io.github.arnabmaji19.attendancesystem.model.AppRole;
import io.github.arnabmaji19.attendancesystem.model.UserDetails;
import io.github.arnabmaji19.attendancesystem.service.RoleService;
import io.github.arnabmaji19.attendancesystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TeacherController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@Valid @RequestBody UserDetails userDetails) {
        logger.info("Accepted UserDetails: " + userDetails.toString());

        // Save the accepted user details as a teacher
        User user = new User(
                userDetails.getUsername(),
                userDetails.getName(),
                passwordEncoder.encode(userDetails.getPassword()),
                roleService.findRoleByName(AppRole.TEACHER));
        userService.save(user);
        return ResponseEntity.ok().build();
    }

}
