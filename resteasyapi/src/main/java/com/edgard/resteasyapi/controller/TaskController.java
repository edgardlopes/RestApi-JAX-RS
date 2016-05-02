/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.resteasyapi.controller;

import com.edgard.appmodel.ServiceLocator;
import com.edgard.appmodel.entity.Task;
import java.net.URI;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author edgard
 */
@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@DeclareRoles({"A", "U"})
public class TaskController {

    @GET
    @RolesAllowed("U")
    public List<Task> list() throws Exception {
        List<Task> tasks = ServiceLocator.getTaskService().readByCriteria(null);
        return tasks;
    }

    @GET
    @Path("/{id}")
    public Task readByID(@PathParam("id") Long id) throws Exception {
        return ServiceLocator.getTaskService().readByID(id);
    }

    @POST
    public Response create(Task task) throws Exception {
        String url = "http://localhost:8080/tasks/";
        ServiceLocator.getTaskService().create(task);
        url += task.getId();
        return Response.created(URI.create(url)).build();
    }

    @PUT
    public Response update(Task task) throws Exception {
        ServiceLocator.getTaskService().update(task);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws Exception {
        ServiceLocator.getTaskService().delete(id);
        return Response.noContent().build();
    }

}
