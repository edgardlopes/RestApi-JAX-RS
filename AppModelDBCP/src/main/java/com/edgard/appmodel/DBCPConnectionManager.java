/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author edgard
 */
public class DBCPConnectionManager {
    private static DBCPConnectionManager instance;
    BasicDataSource ds;
    private DBCPConnectionManager() {
        ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        ds.setUrl("jdbc:postgresql://localhost/app");
        ds.setInitialSize(1);
        ds.setMaxActive(5);
    }
    
    public static DBCPConnectionManager getInstance(){
        if(instance == null){
            instance = new DBCPConnectionManager();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException{
        Connection conn = this.ds.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }
}
