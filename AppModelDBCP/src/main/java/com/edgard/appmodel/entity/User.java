/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel.entity;

import com.edgard.appmodel.base.BaseEntity;

/**
 *
 * @author edgard
 */
public class User extends BaseEntity {

    public static final String ADMIN = "A";
    public static final String USER = "U";

    private String name;
    private String email;
    private String password;
    private String type;

    public User(String name, String email, String password, String type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "JUser{" + "name=" + name + ", email=" + email + ", password=" + password + ", type=" + type + '}';
    }

}
