package com.crudApi.springApi.Service;

import com.crudApi.springApi.Dto.CustomerDetailsDto;

import java.util.List;

public interface Customer_service {
CustomerDetailsDto createUser(CustomerDetailsDto customerDetailsDto);
CustomerDetailsDto getCustomerById(Long id);
CustomerDetailsDto updateUser(Long id,String name,String email,String password);

List<CustomerDetailsDto> getAllAccount();

void DeleteAccount(Long id);
}
