/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository custRepository;

    // ADD
    public Customer addCustomer(Customer cust) {
        return custRepository.save(cust);
    }

    // GET
    public List<Customer> getInfo() {
        return custRepository.findAll();
    }

    // GET BY ID
    public Customer getInfoById(Long custId, Customer custDetails) {
        return custRepository.findById(custId).get();
    }

    // UPDATE
    public Customer updateCustomer(Long custId, Customer custDetails) {
        Customer cust = custRepository.findById(custId).get();
        cust.setName(custDetails.getName());
        cust.setAge(custDetails.getAge());
        cust.setMoney(custDetails.getMoney());
        cust.setPhone(custDetails.getPhone());
        cust.setAddress(custDetails.getAddress());

        return custRepository.save(cust);
    }

    // DELETE
    public void deleteCustomer(Long custId) {
        custRepository.deleteById(custId);
    }

    // SEARCH BY NAME
    public List<Customer> searchCustomer(String keyword) {
        return custRepository.findByNameContainingIgnoreCase(keyword);
    }
    
    // SEARCH BY ID
    public Customer searchCustomerById(Long custId) {
        // Gọi phương thức tìm kiếm sản phẩm theo Id từ repository
        Optional<Customer> product = custRepository.findById(custId);
        return product.orElse(null);
    }

}
