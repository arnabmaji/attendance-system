package io.github.arnabmaji19.attendancesystem.restcontroller;

import io.github.arnabmaji19.attendancesystem.jwt.JwtUtils;
import io.github.arnabmaji19.attendancesystem.model.JwtResponse;
import io.github.arnabmaji19.attendancesystem.model.LogInRequest;
import io.github.arnabmaji19.attendancesystem.model.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/")
    public ResponseEntity<?> authenticate(@Valid @RequestBody LogInRequest logInRequest) {

        var authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        logInRequest.getUsername(),
                        logInRequest.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtils.generateToken(authentication);
        var user = (UserDetailsImpl) authentication.getPrincipal();
        String role = user.getAuthorities().stream().findFirst().get().getAuthority();

        return ResponseEntity.ok(
                new JwtResponse(user.getUsername(), role, token)
        );
    }

}
