/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel.service.base;

import com.edgard.appmodel.entity.User;
import com.edgard.appmodel.base.BaseService;

/**
 *
 * @author edgard
 */
public interface BaseUserService extends BaseService<User>{
    public User login(String email, String password) throws Exception;
}
