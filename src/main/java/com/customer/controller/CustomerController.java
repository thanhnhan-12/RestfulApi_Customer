/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")

public class CustomerController {

    @Autowired
    CustomerService custService;

    // CREATE
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer cust) {
        return custService.addCustomer(cust);
    }

    // GET
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getInfo() {
        return custService.getInfo();
    }

    // GET BY ID
    @RequestMapping(value = "/customers/{custId}", method = RequestMethod.GET)
    public Customer getInfoById(@PathVariable(value = "custId") Long id, @RequestBody Customer custDetails) {
        return custService.getInfoById(id, custDetails);
    }

    // UPDATE
    @RequestMapping(value = "/customers/{custId}", method = RequestMethod.PUT)
    public Customer updateCustomer(@PathVariable(value = "custId") Long id, @RequestBody Customer custDetails) {
        return custService.updateCustomer(id, custDetails);
    }

    // DELETE
    @RequestMapping(value = "/customers/{custId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable(value = "custId") Long id) {
        custService.deleteCustomer(id);
    }

    // SEARCH BY NAME
    @RequestMapping(value = "/customers/search", method = RequestMethod.GET)
    public List<Customer> searchCustomer(@RequestParam(value = "keyword") String keyword) {
        return custService.searchCustomer(keyword);
    }

    // SEARCH BY ID
    @RequestMapping(value = "/products/searchById/{custId}", method = RequestMethod.GET)
    public Customer searchProductById(@PathVariable(value = "custId") Long custId) {
        return custService.searchCustomerById(custId);
    }

}
