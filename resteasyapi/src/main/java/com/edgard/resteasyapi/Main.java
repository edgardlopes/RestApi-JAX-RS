/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.resteasyapi;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * @author edgard
 */
public class Main {

    public static final int PORT = 8080;

    public static void main(String[] args) {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();

        context.setDescriptor("./src/main/webapp/META-INF/web.xml");
        context.setResourceBase("./src/main/webapp");
        context.setContextPath("/");

        context.setParentLoaderPriority(true);

        server.setHandler(context);

        try {
            server.start();
            System.out.println("Server listening at port " + PORT);
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
