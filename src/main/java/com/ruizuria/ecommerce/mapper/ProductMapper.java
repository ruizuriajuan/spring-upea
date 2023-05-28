package com.ruizuria.ecommerce.mapper;

import com.ruizuria.ecommerce.dto.ProductDto;
import com.ruizuria.ecommerce.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "category.id", target = "categoryId")
    })
    ProductDto toProductDto(Product dto);

    @InheritInverseConfiguration
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductDto dto);
}
