package com.thanos.secure_book_api_v2.controllers;

import com.thanos.secure_book_api_v2.dto.LoginRequestDTO;
import com.thanos.secure_book_api_v2.dto.LoginResponseDTO;
import com.thanos.secure_book_api_v2.jwt.JwtUtil;
import com.thanos.secure_book_api_v2.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));

            if (authentication.isAuthenticated()) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getUsername());
                String token = jwtUtil.generateToken(userDetails);

                return ResponseEntity.ok(new LoginResponseDTO(token));
            } else
                return ResponseEntity.status(401).body("Invalid Credentials");
    }
}
