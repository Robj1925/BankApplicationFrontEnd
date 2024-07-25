package com.example.demo.dto;

import com.example.demo.model.Address;
import jakarta.validation.constraints.NotNull;

public class CustomerDto {
    @NotNull
    private String name;
    @NotNull
    private Address address;
  //  @NotNull
    private String customerType;

    public CustomerDto() {
    }

    public CustomerDto(@NotNull String name, Address address, @NotNull String customerType) {
        this.name = name;
        this.address = address;
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "CustomerDto [name=" + name + ", address=" + address + ", customerType=" + customerType + "]";
    }
}
