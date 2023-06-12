package com.ruizuria.ecommerce.mapper;

import com.ruizuria.ecommerce.dto.UserDto;
import com.ruizuria.ecommerce.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "role.description", target = "role")
    UserDto toUserDto(User user);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "role", ignore = true),
            @Mapping(target = "authorities", ignore = true)
    })
    User toUser(UserDto dto);

}
