package com.ecommerce.Persistence.Mappers;

import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.Entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    Customer toEntity(CustomerDTO customerDto);
    CustomerDTO toDto(Customer customer);
}