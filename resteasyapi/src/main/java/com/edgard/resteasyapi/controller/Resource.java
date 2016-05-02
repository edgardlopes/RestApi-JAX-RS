/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.resteasyapi.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author edgard
 */
@Produces(MediaType.TEXT_PLAIN)
@Path("/")
public class Resource {

    @GET
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/books")
    public String getBooks() {
        return "books";
    }

    @GET
    @Path("/book/{isbn}")
    public String getBook(@PathParam("isbn") String id) {
        return "11123";
    }
}
