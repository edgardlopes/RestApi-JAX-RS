package com.edgard.resteasyapi.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.edgard.resteasyapi.controller.Resource;
import com.edgard.resteasyapi.controller.TaskController;
import com.edgard.resteasyapi.controller.UserController;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author edgard
 */
//@ApplicationPath("/api")
public class AppConfig extends Application {
    public static final String PATH_SERVER = "http://localhost:8080";
    public static final String SECRET_KEY = "secretKey";
    private static final Set<Class<?>> CLASSES;

    static {
        HashSet<Class<?>> tmp = new HashSet<Class<?>>();
        tmp.add(Resource.class);
        tmp.add(TaskController.class);
        tmp.add(UserController.class);
        
        CLASSES = Collections.unmodifiableSet(tmp);
    }

    @Override
    public Set<Class<?>> getClasses() {

        return CLASSES;
    }

}
