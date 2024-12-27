package com.crudApi.springApi.Service.impl;

import com.crudApi.springApi.Dto.CustomerDetailsDto;
import com.crudApi.springApi.Entity.Customer_details;
import com.crudApi.springApi.Mapper.Mapper;
import com.crudApi.springApi.Repository.Customer_repo;
import com.crudApi.springApi.Service.Customer_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements Customer_service {
    @Autowired
    private Customer_repo customerRepo;
    @Override
    @Transactional
    public CustomerDetailsDto createUser(CustomerDetailsDto customerDetailsDto) {
        Customer_details customerDetails= Mapper.mapToCustomerDetails(customerDetailsDto);
        Customer_details saveDetails=customerRepo.save(customerDetails);
        return Mapper.mapToCustomerDetailsDto(saveDetails);
    }

    @Override
    public CustomerDetailsDto getCustomerById(Long id) {
        Customer_details customerDetails=customerRepo.findById(id).orElseThrow(()->new RuntimeException("Customer doesn't exist"));
        return Mapper.mapToCustomerDetailsDto(customerDetails);
    }

    @Override
    public CustomerDetailsDto updateUser(Long id, String name, String email, String password) {
        Customer_details customerDetails=customerRepo.findById(id).orElseThrow(()->new RuntimeException("Customer doesn't exist"));
        customerDetails.setName(name);
        customerDetails.setEmail(email);
        customerDetails.setPassword(password);
        Customer_details saveDetails=customerRepo.save(customerDetails);
        return Mapper.mapToCustomerDetailsDto(saveDetails);
    }

    @Override
    public List<CustomerDetailsDto> getAllAccount() {
        List<Customer_details> customerDetails=customerRepo.findAll();
       return customerDetails.stream().map((CustomerDetails)->Mapper.mapToCustomerDetailsDto(CustomerDetails)).collect(Collectors.toList());
    }

    @Override
    public void DeleteAccount(Long id) {
        Customer_details customerDetails=customerRepo.findById(id).orElseThrow(()->new RuntimeException("User Doesn't Exist"));
        customerRepo.deleteById(id);
    }




}
