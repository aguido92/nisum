package com.nisum.challenge.service;

import com.nisum.challenge.dto.RegisterUserRequest;
import com.nisum.challenge.dto.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest user);
}
