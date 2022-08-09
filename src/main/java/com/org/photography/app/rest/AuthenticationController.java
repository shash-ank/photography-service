package com.org.photography.app.rest;


import com.org.photography.app.payload.request.LoginRequest;
import com.org.photography.app.repository.CustomerRepository;
import com.org.photography.app.payload.response.JwtResponse;
import com.org.photography.app.security.services.UserDetailsImpl;
import com.org.photography.app.security.services.jwt.JwtUtils;
import com.org.photography.app.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class   AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    CustomerService customerService;
    @PostMapping( "/auth/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest)
    {
        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail()));
 

    }


}
