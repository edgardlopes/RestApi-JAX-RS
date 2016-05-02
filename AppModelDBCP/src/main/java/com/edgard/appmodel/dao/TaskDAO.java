/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel.dao;

import com.edgard.appmodel.criteria.TaskCriteria;
import com.edgard.appmodel.entity.Task;
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
public class TaskDAO implements BaseDAO<Task> {

    @Override
    public void create(Task e, Connection conn) throws Exception {
        String sql = "INSERT INTO task(usuario_fk, name, done) VALUES (?, ?, ?) returning id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, e.getUser().getId());
        ps.setString(2, e.getName());
        ps.setBoolean(3, e.isDone());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public List<Task> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        String sql = applyCriteria(criteria);
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            Task task = new Task();
            task.setDone(rs.getBoolean("done"));
            task.setId(rs.getLong("id"));
            task.setName(rs.getString("name"));

            Long userFK = rs.getLong("usuario_fk");
            if (userFK != null && userFK > 0) {
                User u = new User();
                u.setId(userFK);
                task.setUser(u);
            }
            tasks.add(task);
        }
        rs.close();
        s.close();
        return tasks;
    }

    @Override
    public Task readByID(Long id, Connection conn) throws Exception {
        String sql = "SELECT * FROM task WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Task task = null;
        if (rs.next()) {
            task = new Task();
            task.setDone(rs.getBoolean("done"));
            task.setId(rs.getLong("id"));
            task.setName(rs.getString("name"));

            Long userFK = rs.getLong("usuario_fk");
            if (userFK != null && userFK > 0) {
                User u = new User();
                u.setId(userFK);
                task.setUser(u);
            }
        }
        rs.close();
        ps.close();
        return task;
    }

    @Override
    public void update(Task e, Connection conn) throws Exception {
        String sql = "UPDATE task SET name=?, done=? WHERE id=? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, e.getName());
        ps.setBoolean(2, e.isDone());
        ps.setLong(3, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM task WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public String applyCriteria(Map<String, Object> criteria) throws Exception {
        String sql = "SELECT * FROM task where true";
        if (criteria != null && !criteria.isEmpty()) {
            if(criteria.containsKey(TaskCriteria.USER_FK) && (Long)criteria.get(TaskCriteria.USER_FK) > 0){
                sql += " AND usuario_fk=" + criteria.get(TaskCriteria.USER_FK);
            }
        }
        return sql;
    }

    @Override
    public Long countByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
