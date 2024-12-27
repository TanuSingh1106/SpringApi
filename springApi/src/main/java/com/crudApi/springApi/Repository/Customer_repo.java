package com.crudApi.springApi.Repository;

import com.crudApi.springApi.Entity.Customer_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_repo extends JpaRepository<Customer_details,Long> {

}
