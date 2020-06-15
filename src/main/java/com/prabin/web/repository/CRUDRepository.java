/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.web.repository;

import java.util.List;

/**
 *
 * @author Prasbin
 */
public interface CRUDRepository<T> {
    List<T> findAll();
    T findbyId(int id);
    int insert(T model);
    int update(T model);
    int deleteById(int id);
}
