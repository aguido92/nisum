package com.nisum.challenge.mapper;

import com.nisum.challenge.dto.UserPhone;
import com.nisum.challenge.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);
    UserPhone phoneToUserPhone(Phone phone);
    Phone userPhoneToPhone(UserPhone userPhone);

}
