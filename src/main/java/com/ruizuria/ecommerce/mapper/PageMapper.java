package com.ruizuria.ecommerce.mapper;

import com.ruizuria.ecommerce.dto.PageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface PageMapper {
    @Mappings({
            @Mapping(source = "number", target = "pageNumber"),
            @Mapping(source = "size", target = "pageSize")
    })
    PageDto toPageDto(Page page);
}
