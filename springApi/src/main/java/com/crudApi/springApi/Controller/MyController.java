package com.crudApi.springApi.Controller;

import com.crudApi.springApi.Dto.CustomerDetailsDto;
import com.crudApi.springApi.Service.Customer_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {
    @Autowired
    public Customer_service customerService;
    @PostMapping("/Create")
    public ResponseEntity<CustomerDetailsDto> createUser(@RequestBody CustomerDetailsDto customerDetailsDto){
        return new ResponseEntity<>(customerService.createUser(customerDetailsDto), HttpStatus.CREATED);
    }

    @GetMapping("/GetUser/{id}")
    public ResponseEntity<CustomerDetailsDto> getCustomerById(@PathVariable long id,@RequestBody CustomerDetailsDto customerDetailsDto){
       return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<CustomerDetailsDto> updateCustomer(@PathVariable long id, @RequestBody Map<String,String>request){
        String name = request.get("name");
        String email = request.get("email");
        String password = request.get("password");
        CustomerDetailsDto customerDetailsDto=customerService.updateUser(id,name,email,password);
        return ResponseEntity.ok(customerDetailsDto);
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        customerService.DeleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }

    @GetMapping("/getAllAccount")
    public ResponseEntity<List<CustomerDetailsDto>> getAllAccount(@RequestBody CustomerDetailsDto customerDetailsDto){
        List<CustomerDetailsDto> list= customerService.getAllAccount();
        return ResponseEntity.ok(list);
    }
}
