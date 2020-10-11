package com.phoenix.message.web.mapper;

import com.phoenix.message.web.dto.UserDto;
import com.phoenix.message.web.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter extends BaseMapper {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto userToUserDao(User user);

}
