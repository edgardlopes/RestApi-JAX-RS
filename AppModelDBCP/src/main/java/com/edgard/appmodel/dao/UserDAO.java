/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel.dao;

import com.edgard.appmodel.criteria.UserCriteria;
import com.edgard.appmodel.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.edgard.appmodel.base.BaseDAO;

/**
 *
 * @author edgard
 */
public class UserDAO implements BaseDAO<User> {

    @Override
    public void create(User e, Connection conn) throws Exception {
        String sql = "INSERT INTO usuario(name, email, password, type) VALUES (?, ?, ?, ?) returning id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, e.getName());
        ps.setString(2, e.getEmail());
        ps.setString(3, e.getPassword());
        ps.setString(4, e.getType());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }

        rs.close();
        ps.close();
    }

    @Override
    public List<User> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        String sql = applyCriteria(criteria);

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<User> users = new ArrayList<User>();
        while (rs.next()) {
            User user = new User();
            user.setName(rs.getString("name"));
            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            user.setType(rs.getString("type"));
            users.add(user);
        }

        rs.close();
        s.close();

        return users;
    }

    @Override
    public User readByID(Long id, Connection conn) throws Exception {
        String sql = "SELECT * FROM usuario where id=? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setName(rs.getString("name"));
            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            user.setType(rs.getString("type"));
        }
        rs.close();
        ps.close();

        return user;
    }

    @Override
    public void update(User e, Connection conn) throws Exception {
        String sql = "UPDATE usuario SET name=?, email=?  WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, e.getName());
        ps.setString(2, e.getEmail());
        ps.setLong(3, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM usuario WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public String applyCriteria(Map<String, Object> criteria) throws Exception {
        String sql = "SELECT * FROM usuario WHERE true ";

        if (criteria != null && !criteria.isEmpty()) {
            if (criteria.containsKey(UserCriteria.EMAIL_EQ) && criteria.get(UserCriteria.EMAIL_EQ) != null) {
                sql += " AND email='" + criteria.get(UserCriteria.EMAIL_EQ) + "'";
            }

            if (criteria.containsKey(UserCriteria.PASSWORD_EQ) && criteria.get(UserCriteria.PASSWORD_EQ) != null) {
                sql += " AND password='" + criteria.get(UserCriteria.PASSWORD_EQ) + "'";
            }

            if (criteria.containsKey(UserCriteria.TYPE_EQ) && criteria.get(UserCriteria.TYPE_EQ) != null) {
                sql += " AND type='" + criteria.get(UserCriteria.TYPE_EQ) + "'";
            }
        }

        return sql;
    }

    @Override
    public Long countByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
