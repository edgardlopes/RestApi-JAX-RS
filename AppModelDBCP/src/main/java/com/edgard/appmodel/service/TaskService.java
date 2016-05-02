/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel.service;

import com.edgard.appmodel.ConnectionManager;
import com.edgard.appmodel.DBCPConnectionManager;
import com.edgard.appmodel.dao.TaskDAO;
import com.edgard.appmodel.entity.Task;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.edgard.appmodel.service.base.BaseTaskService;

/**
 *
 * @author edgard
 */
public class TaskService implements BaseTaskService{
    
    @Override
    public void create(Task e) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        TaskDAO dao = new TaskDAO();
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
    public List<Task> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        TaskDAO dao = new TaskDAO();
        List<Task> users = new ArrayList<>();

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
    public Task readByID(Long id) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        TaskDAO dao = new TaskDAO();
        Task user = null;

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
    public void update(Task e) throws Exception {
        Connection conn = DBCPConnectionManager.getInstance().getConnection();
        TaskDAO dao = new TaskDAO();
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
        TaskDAO dao = new TaskDAO();
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
