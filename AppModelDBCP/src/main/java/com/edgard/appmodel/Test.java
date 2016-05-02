/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.appmodel;

import com.edgard.appmodel.criteria.TaskCriteria;
import com.edgard.appmodel.entity.Task;
import com.edgard.appmodel.entity.User;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edgard
 */
public class Test {

    private void execute() throws Exception {
//        User user = new User("Ze", "ze@test.com", "123");
//        ServiceLocator.getUserService().create(user);
//        List<JUser> users = ServiceLocator.getUserService().readByCriteria(null);
//        for (User user : users) {
//            System.out.println(user);
//        }
//        User user = new User("alterado", "alterado@test.com", "123");
//        user.setId(1L);
//        ServiceLocator.getUserService().update(user);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(i + ": " + ServiceLocator.getUserService().readByID(new Long(i)));
//        }
////        ServiceLocator.getUserService().delete(1l);
//        User user = ServiceLocator.getUserService().readByID(3l);
//        Task task = new Task("Aprender EASYRest", Boolean.FALSE, user);
//        ServiceLocator.getTaskService().create(task);

//        Map<String, Object> criteria = new HashMap<>();
//        criteria.put(TaskCriteria.USER_FK, 3l);
//    List<JTask> tasks = ServiceLocator.getTaskService().readByCriteria(criteria);
//        for (Task aux : tasks) {
//            System.out.println(aux);
//        }
//        for (int i = 1; i <= 2 ; i++) {
//            System.out.println(ServiceLocator.getTaskService().readByID(new Long(i)));
//        }
//        Task task = new Task("Já aprendi jersey", Boolean.TRUE, null);
//        task.setId(1l);
//        ServiceLocator.getTaskService().update(task);
//    ServiceLocator.getTaskService().delete(3l);
        Date eam = new Date(2016, 26, 4, 10, 19, 0);
        Date sam = new Date(2016, 26, 4, 13, 6, 0);

        Date difam = new Date(sam.getTime() - eam.getTime());

        Date eda = new Date(2016, 26, 4, 14, 6, 0);
        Date sda = new Date(2016, 26, 4, 17, 19, 0);
        
        Date difda = new Date(sda.getTime() - eda.getTime());
        
        System.out.println("sa");
    }

    public static void main(String[] args) {
        Test t = new Test();

        try {
            t.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
