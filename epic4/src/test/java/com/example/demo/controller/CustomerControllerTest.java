package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.*;
import com.example.demo.exception.*;

import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private CustomerService customerService;

	@MockBean
	private RestTemplate restTemplate;
	@MockBean
	JSONObject jsonResponse;
	
	 private CustomerDto customerDto;
	    private Customer customer;
	    private String customerJsonString;
	    private CustomerDto customerDtoWithoutCityOrProvidence;

	    @BeforeEach
	    void setUp() throws Exception {
	        customerDto = new CustomerDto("John Doe", new Address("123", "A1B 2C3", "Toronto", "ON"), "person");
	        customerDtoWithoutCityOrProvidence = new CustomerDto("John Doe", new Address("123", "A1B 2C3", null, null), "person");

	        customer = new Person(customerDto.getName(), customerDto.getAddress(), new ArrayList<>());
	        customerJsonString = objectMapper.writeValueAsString(customerDto);
	    }
    @Test
    void test_CreateCustomer_ReturnsCustomer() throws Exception  {
    	String url = "/customer";
    	String geoCodeUrl = String.format("https://geocoder.ca/?locate=%s&geoit=XML&json=1",
    			customerDtoWithoutCityOrProvidence.getAddress().getPostalCode());

        String apiResponse = "{ \"standard\": { \"city\": \"Toronto\", \"prov\": \"ON\" } }";
        when(restTemplate.getForObject(geoCodeUrl, String.class)).thenReturn(apiResponse);
        
      //  when(restTemplate.getForObject(geoCodeUrl, String.class)).thenReturn(apiResponse);


        when(customerService.createCustomer(customerDtoWithoutCityOrProvidence)).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJsonString))
                .andExpect(status().isCreated());
    }
    @Test
    void test_GetAllCustomers_ReturnsListOfTwoCustomers_WhenProvidedTwoCustomers() throws Exception {
        List<Customer> customers = Arrays.asList(customer, new Company("Company XYZ", new Address("456", "B2C 3D4", "Toronto", "ON"), new ArrayList<>()));
        String url = "/customers";
        String customersJsonString = objectMapper.writeValueAsString(customers);

        when(customerService.findAllCustomers()).thenReturn(customers);

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpectAll(status().isOk(), MockMvcResultMatchers.content().json(customersJsonString));
    }
    @Test
    void test_GetCustomerById_ReturnsCustomerWithSpecifiedId_WhenGivenAnId() throws Exception {
        long customerId = 1L;
        String url = "/customer/" + customerId;
        String customerJsonString = objectMapper.writeValueAsString(customer);
        
        when(customerService.findById(customerId)).thenReturn(customer);

        mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(customerJsonString));
    }
    @Test
    void test_GetCustomerById_ThrowsCustomerNotFoundException_WhenNoCustomerWithIdExists() throws Exception {
        long nonExistentCustomerId = 999L; 
        String url = "/customer/" + nonExistentCustomerId;

        when(customerService.findById(nonExistentCustomerId)).thenThrow(new CustomerNotFoundException("Customer with id: " + nonExistentCustomerId + " does not exist!"));
        mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound()); 
    }

}
