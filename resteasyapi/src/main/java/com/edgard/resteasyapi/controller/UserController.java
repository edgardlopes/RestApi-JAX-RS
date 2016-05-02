/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.resteasyapi.controller;

import com.edgard.appmodel.ServiceLocator;
import com.edgard.appmodel.entity.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.edgard.resteasyapi.config.AppConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
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
@Path("/users")
@DeclareRoles({"A", "U"})
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @GET
    @RolesAllowed("A")
    public List<User> list() throws Exception {
        return ServiceLocator.getUserService().readByCriteria(null);
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("A")
    public User readByID(@PathParam("id") Long id) throws Exception {
        return ServiceLocator.getUserService().readByID(id);
    }

    @POST
    @RolesAllowed("A")
    public Response create(User user) throws Exception {
        ServiceLocator.getUserService().create(user);
        String location = AppConfig.PATH_SERVER + "/users/" + user.getId();
        return Response.created(URI.create(location)).build();
    }

    @PUT
    @RolesAllowed({"A", "U"})
    public Response update(User user) throws Exception {
        ServiceLocator.getUserService().update(user);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws Exception {
        ServiceLocator.getUserService().delete(id);
        return Response.noContent().build();
    }

    @POST
    @Path("/login")
    @PermitAll
    public Response login(String login) throws Exception {
        Map<String, Object> loginObject = new Gson().fromJson(login, Map.class);
        String email = (String) loginObject.get("email");
        String password = (String) loginObject.get("password");
        if (email != null && !email.isEmpty()) {
            if (password != null && !email.isEmpty()) {
                User userFound = ServiceLocator.getUserService().login(email, password);
                if (userFound != null) {

                    Calendar expires = Calendar.getInstance();
                    expires.add(Calendar.DATE, 5);

                    Map<String, Object> claims = new HashMap<>();
                    claims.put("id", userFound.getId().toString());

                    String token = Jwts.builder().setClaims(claims).setExpiration(expires.getTime()).signWith(SignatureAlgorithm.HS512, AppConfig.SECRET_KEY).compact();

                    JsonObject object = new JsonObject();
                    object.add("user", new Gson().toJsonTree(userFound, User.class));
                    object.addProperty("token", token);

                    return Response.ok(object).status(200).build();
                }
            }
        }

        return Response.status(401).build();
    }
}
