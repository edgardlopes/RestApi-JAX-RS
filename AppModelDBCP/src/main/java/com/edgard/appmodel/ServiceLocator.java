/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel;

import com.edgard.appmodel.service.TaskService;
import com.edgard.appmodel.service.UserService;
import com.edgard.appmodel.service.base.BaseTaskService;
import com.edgard.appmodel.service.base.BaseUserService;

/**
 *
 * @author edgard
 */
public class ServiceLocator {
    public static BaseUserService getUserService(){
        return new UserService();
    }
    
    public static BaseTaskService getTaskService(){
        return new TaskService();
    }
}
