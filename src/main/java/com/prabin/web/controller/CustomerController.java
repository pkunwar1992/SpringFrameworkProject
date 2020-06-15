/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.web.controller;

import com.prabin.web.entity.Customer;
import com.prabin.web.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Prasbin
 */
@Controller
@RequestMapping(value="/admin/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    
    @GetMapping
    public String index(ModelMap map){
       map.addAttribute("customers", repository.findAll());
       return "customers/index";
    }
    
    @PostMapping
    public String save(Customer customer){
        if(customer.getId()==0){
            repository.insert(customer);
        }else{
            repository.update(customer);
        }
       return "redirect:/admin/customers?success";
    }
    
    @GetMapping(value = "/add")
    public String add(ModelMap map){
        return "customers/add";
    }
    
    @GetMapping(value = "/edit/{id}")
    public String edit(ModelMap map,@PathVariable("id")int id){
        map.addAttribute("customer", repository.findbyId(id));
        return "customers/edit";
    }
    
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")int id){
        repository.deleteById(id);
        return "redirect:/admin/customers?success";
    }
    
    @GetMapping(value = "/json")
    @ResponseBody
    public List<Customer> json(){
        return repository.findAll();
    }
    
    @GetMapping(value = "/json/{id}")
    @ResponseBody
    public Customer jsonByID(@PathVariable("id")int id){
        return repository.findbyId(id);
    }
}
