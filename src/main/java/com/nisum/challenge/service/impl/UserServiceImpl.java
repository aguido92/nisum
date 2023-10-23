package com.nisum.challenge.service.impl;

import com.nisum.challenge.dto.RegisterUserRequest;
import com.nisum.challenge.dto.RegisterUserResponse;
import com.nisum.challenge.mapper.UserMapper;
import com.nisum.challenge.model.Phone;
import com.nisum.challenge.model.User;
import com.nisum.challenge.repository.PhoneRepository;
import com.nisum.challenge.repository.UserRepository;
import com.nisum.challenge.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    private final UserMapper userMapper= Mappers.getMapper(UserMapper.class);

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        User user = userMapper.registerUserRequestToUser(request);
        User saved = userRepository.save(user);
        for (Phone phone : saved.getPhones()) {
            phone.setUser(saved);
            phoneRepository.save(phone);
        }
        return userMapper.userToRegisterUserResponse(saved);
    }
}
