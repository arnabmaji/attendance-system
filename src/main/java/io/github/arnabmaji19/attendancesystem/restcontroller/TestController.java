package io.github.arnabmaji19.attendancesystem.restcontroller;

import io.github.arnabmaji19.attendancesystem.repository.StudentDetailRepository;
import io.github.arnabmaji19.attendancesystem.service.RoleService;
import io.github.arnabmaji19.attendancesystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final UserService userService;
    private final RoleService roleService;
    private StudentDetailRepository studentDetailRepository;

    @Autowired
    public TestController(UserService userService, RoleService roleService, StudentDetailRepository studentDetailRepository) {
        this.userService = userService;
        this.roleService = roleService;
        this.studentDetailRepository = studentDetailRepository;
    }

    @GetMapping("/")
    public String test() {
        return "Test";
    }
}
