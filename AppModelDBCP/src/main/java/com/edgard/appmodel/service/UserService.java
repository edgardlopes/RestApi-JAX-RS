/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel.service;

import com.edgard.appmodel.ConnectionManager;
import com.edgard.appmodel.DBCPConnectionManager;
import com.edgard.appmodel.criteria.UserCriteria;
import com.edgard.appmodel.dao.UserDAO;
import com.edgard.appmodel.entity.User;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.edgard.appmodel.service.base.BaseUserService;

/**
 *
 * @author edgard
 */
public class UserService implements BaseUserService {

    @Override
    public User login(String email, String password) throws Exception {
        Map<String, Object> criteria = new HashMap<>();
        criteria.put(UserCriteria.EMAIL_EQ, email);
        criteria.put(UserCriteria.PASSWORD_EQ, password);
        
        List<User> users = readByCriteria(criteria);
        User userFound = null;
        if(users != null && !users.isEmpty() && users.size() == 1){
            userFound = users.get(0);
        }
        return userFound;
    }

    @Override
    public void create(User e) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        UserDAO dao = new UserDAO();
        try {
            dao.create(e, conn);
            conn.commit();
        } catch (Exception ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.close();
        }
    }

    @Override
    public List<User> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        UserDAO dao = new UserDAO();
        List<User> users = new ArrayList<>();

        try {
            users = dao.readByCriteria(criteria, conn);
            conn.commit();
        } catch (Exception ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.close();
        }
        return users;
    }

    @Override
    public User readByID(Long id) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        UserDAO dao = new UserDAO();
        User user = null;

        try {
            user = dao.readByID(id, conn);
            conn.commit();
        } catch (Exception ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.close();
        }
        return user;
    }

    @Override
    public void update(User e) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        UserDAO dao = new UserDAO();
        try {
            dao.update(e, conn);
            conn.commit();
        } catch (Exception ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.close();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        UserDAO dao = new UserDAO();
        try {
            dao.delete(id, conn);
            conn.commit();
        } catch (Exception ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.close();
        }
    }

    @Override
    public Long countByCriteria(Map<String, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
