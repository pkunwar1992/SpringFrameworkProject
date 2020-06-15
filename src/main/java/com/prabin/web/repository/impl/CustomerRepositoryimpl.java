/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.web.repository.impl;

import com.prabin.web.entity.Customer;
import com.prabin.web.repository.CustomerRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prasbin
 */
@Repository
public class CustomerRepositoryimpl implements CustomerRepository {
    @Autowired
    private JdbcTemplate template;
    
    @Override
    public List<Customer> findAll()  {
        String sql = "select * from tbl_customers";
        return template.query(sql, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs , int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setContactNo(rs.getString("contact_no"));
                customer.setCreatedDate(rs.getDate("created_date"));
                customer.setStatus(rs.getBoolean("status"));
                return customer;
            }
        });
    }

    @Override
    public Customer findbyId(int id){
        String sql = "select * from tbl_customers where id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs , int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setContactNo(rs.getString("contact_no"));
                customer.setCreatedDate(rs.getDate("created_date"));
                customer.setStatus(rs.getBoolean("status"));
                return customer;
            }
        });
    }

    @Override
    public int insert(Customer model){
        String sql = "insert into tbl_customers(first_name,last_name,email,"
                + "contact_no,status)values(?,?,?,?,?)";

        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(),
            model.getContactNo(), model.isStatus()
        });
    }

    @Override
    public int update(Customer model){
        String sql = "update tbl_customers set first_name=?,last_name=?,"
                + "email=?,contact_no=?,status=? where id=?";

        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(),
            model.getContactNo(), model.isStatus(), model.getId()
        });
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from tbl_customers where id=?";
        return template.update(sql, new Object[]{
            id
        });
    }
}
