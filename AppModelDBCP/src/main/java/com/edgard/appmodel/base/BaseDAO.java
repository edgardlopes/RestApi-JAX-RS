/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel.base;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edgard
 */
public interface BaseDAO<E extends BaseEntity> {

    public void create(E e, Connection conn) throws Exception;

    public List<E> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception;

    public E readByID(Long id, Connection conn) throws Exception;

    public void update(E e, Connection conn) throws Exception;

    public void delete(Long id, Connection conn) throws Exception;
    
    public String applyCriteria(Map<String, Object> criteria) throws Exception;
   
    public Long countByCriteria(Map<String, Object> criteria, Connection conn) throws Exception;
}
