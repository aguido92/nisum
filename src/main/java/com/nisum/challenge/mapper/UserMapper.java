package com.nisum.challenge.mapper;

import com.nisum.challenge.dto.RegisterUserRequest;
import com.nisum.challenge.dto.RegisterUserResponse;
import com.nisum.challenge.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = PhoneMapper.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User registerUserRequestToUser(RegisterUserRequest request);
    RegisterUserResponse userToRegisterUserResponse(User user);

}
