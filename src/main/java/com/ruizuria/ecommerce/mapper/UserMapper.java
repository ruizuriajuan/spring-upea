package com.ruizuria.ecommerce.mapper;

import com.ruizuria.ecommerce.dto.UserDto;
import com.ruizuria.ecommerce.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "role.description",  target = "role")
    UserDto toUserDto(User user);
}
