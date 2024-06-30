package com.johan.market.persistence.mapper;

import com.johan.market.domain.Category;
import com.johan.market.persistence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Category toCatagory(Categoria categoria);

}
