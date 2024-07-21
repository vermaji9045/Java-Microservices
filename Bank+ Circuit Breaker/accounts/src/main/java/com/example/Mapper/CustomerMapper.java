package com.example.Mapper;

import com.example.DtoClass.CustomerDetailsDto;
import com.example.DtoClass.CustomerDto;
import com.example.Entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto)
    {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static CustomerDetailsDto mapToCustomerDetailsDto(Customer customer, CustomerDetailsDto customerDetailsDto)
    {
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDto;
    }
    public static Customer mapToCustomer(CustomerDto customerDto,Customer customer)
    {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());

        return customer;
    }


}
