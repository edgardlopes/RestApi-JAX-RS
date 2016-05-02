/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel;

import java.sql.Connection;
import org.postgresql.ds.PGPoolingDataSource;


/**
 *
 * @author edgard
 */
public class ConnectionManager {
    private PGPoolingDataSource dataSource;
 
    public Connection getConnection() throws Exception {
        Connection conn = dataSource.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }
 
    private ConnectionManager() {
        dataSource = new PGPoolingDataSource();
        dataSource.setDataSourceName("app");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("app");
        dataSource.setUser("postgres");
         
        dataSource.setPassword("postgres");
         
        dataSource.setMaxConnections(30);
        dataSource.setInitialConnections(10);
    }
    private static ConnectionManager instance;
 
    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }
}
