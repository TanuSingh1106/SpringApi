package com.crudApi.springApi.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Customer_Details")
public class Customer_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column

    private Long id;

    @Version // Do not manually set this field
    private Long version;
    @Column
    private String name;
    @Column
    private String email;

    @Column
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer_details(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Customer_details(){

    }
}
