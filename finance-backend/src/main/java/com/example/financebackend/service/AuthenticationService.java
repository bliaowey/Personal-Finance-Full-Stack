package com.example.financebackend.service;

import com.example.financebackend.dto.JwtAuthenticationResponse;
import com.example.financebackend.dto.RefreshTokenRequest;
import com.example.financebackend.dto.SignInRequest;
import com.example.financebackend.dto.SignupRequest;
import com.example.financebackend.entity.User;

public interface AuthenticationService {
    User signUp(SignupRequest signupRequest);

    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
