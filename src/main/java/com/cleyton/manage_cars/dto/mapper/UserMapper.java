package com.cleyton.manage_cars.dto.mapper;

import com.cleyton.manage_cars.dto.request.UserCreateDto;
import com.cleyton.manage_cars.dto.response.CarResponseDto;
import com.cleyton.manage_cars.dto.response.UserResponseDto;
import com.cleyton.manage_cars.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static User toUser(UserCreateDto dto) {
        return new ModelMapper().map(dto,User.class);
    }

    public static UserResponseDto toDto(User user) {
        return new ModelMapper().map(user, UserResponseDto.class);
    }

}
