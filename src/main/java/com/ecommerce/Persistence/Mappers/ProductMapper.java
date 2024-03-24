package com.ecommerce.Persistence.Mappers;

import com.ecommerce.Persistence.DTOs.CustomerDTO;

import com.ecommerce.Persistence.DTOs.ProductDTO;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

        com.ecommerce.Persistence.Mappers.ProductMapper INSTANCE = Mappers.getMapper(com.ecommerce.Persistence.Mappers.ProductMapper.class);

        Product toEntity(ProductDTO productDTO);
        ProductDTO toDto(Product product);

}

