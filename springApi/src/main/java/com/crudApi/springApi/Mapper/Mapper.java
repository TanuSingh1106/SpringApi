package com.crudApi.springApi.Mapper;

import com.crudApi.springApi.Dto.CustomerDetailsDto;
import com.crudApi.springApi.Entity.Customer_details;

public class Mapper {

    public static Customer_details mapToCustomerDetails(CustomerDetailsDto customerDetailsDto){
        // Do not set id, let Hibernate handle it
        return new Customer_details(
                null,  // Let Hibernate handle the ID
                customerDetailsDto.getName(),
                customerDetailsDto.getEmail(),
                customerDetailsDto.getPassword()
        );
    }

    public static CustomerDetailsDto mapToCustomerDetailsDto(Customer_details customerDetails){
        return new CustomerDetailsDto(
                customerDetails.getId(),
                customerDetails.getName(),
                customerDetails.getEmail(),
                customerDetails.getPassword()
        );
    }
}

