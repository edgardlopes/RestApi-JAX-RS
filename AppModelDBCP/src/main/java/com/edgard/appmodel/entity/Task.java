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
public class Task extends BaseEntity {

    private String name;
    private Boolean done;
    private User user;

    public Task(String name, Boolean done, User user) {
        this.name = name;
        this.done = done;
        this.user = user;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "JTask{id=" + id + ", name=" + name + ", done=" + done + ", user=" + user + '}';
    }

}
