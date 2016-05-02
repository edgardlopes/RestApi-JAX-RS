/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edgard.resteasyapi.interceptor;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;

/**
 *
 * @author edgard
 */
@Provider
@ServerInterceptor
public class SecurityInterceptor implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
//        ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestContext.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
//        Method method = methodInvoker.getMethod();
//        ServerResponse response = null;
//
//        Headers<Object> headers = new Headers<Object>();
//        headers.add("Content-Type", "text/plain");
//
//        if (!method.isAnnotationPresent(PermitAll.class)) {
//            MultivaluedMap<String, String> header = requestContext.getHeaders();
//            List<String> tokens = header.get("x-access-token");
//
//            if (tokens == null || tokens.isEmpty() || tokens.get(0).isEmpty()) {
//                response = new ServerResponse("Empty token", 401, headers);
//            } else {
//                String token = tokens.get(0);
//
//                try {
//                    Claims claims = Jwts.parser().setSigningKey(AppConfig.SECRET_KEY).parseClaimsJws(token).getBody();
//                    Long id = Long.parseLong((String) claims.get("id"));
//
//                    JUser user = ServiceLocator.getUserService().readByID(id);
//                    if (user == null) {
//                        response = new ServerResponse("User not found", 401, headers);
//                    } else {
//
//                        RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
//                        if (rolesAllowed != null) {
//                            Set<String> roles = new HashSet<>(Arrays.asList(rolesAllowed.value()));
//                            String userType = user.getType();
//
//                            if (!roles.contains(user.getType())) {
//                                response = new ServerResponse("Service available just for " + roles, 401, headers);
//                            }
//                        }
//                    }
//
//                } catch (ExpiredJwtException expiredJwtException) {
//                    response = new ServerResponse("Token expired", 401, headers);
//                } catch (Exception ex) {
//                    response = new ServerResponse("Authentication failed", 401, headers);
//                }
//            }
//
//        }
//
//    //        if (response != null) {
//        requestContext.abortWith(response);
//    //        }

    }

//    @Override
//    public ServerResponse preProcess(HttpRequest request, ResourceMethodInvoker methodInvoked) throws Failure, WebApplicationException {
//        Method method = methodInvoked.getMethod();
//        ServerResponse response = null;
//
//        Headers<Object> headers = new Headers<Object>();
//        headers.add("Content-Type", "text/plain");
//
//        if (!method.isAnnotationPresent(PermitAll.class)) {
//            HttpHeaders header = request.getHttpHeaders();
//            List<String> tokens = header.getRequestHeader("x-access-token");
//
//            if (tokens == null || tokens.isEmpty() || tokens.get(0).isEmpty()) {
//                response = new ServerResponse("Empty token", 401, headers);
//
//            } else {
//                String token = tokens.get(0);
//
//                try {
//                    Claims claims = Jwts.parser().setSigningKey(AppConfig.SECRET_KEY).parseClaimsJws(token).getBody();
//                    Long id = Long.parseLong(claims.getId());
//
//                    JUser user = ServiceLocator.getUserService().readByID(id);
//                    if (user == null) {
//                        response = new ServerResponse("User not found", 401, headers);
//                    } else {
//
//                        RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
//                        Set<String> roles = new HashSet<>(Arrays.asList(rolesAllowed.value()));
//
//                        if (!roles.contains(user.getType())) {
//                            response = new ServerResponse("Service available just for ADMINS.", 401, headers);
//                        }
//                    }
//
//                } catch (ExpiredJwtException expiredJwtException) {
//                    response = new ServerResponse("Token expired", 401, headers);
//                } catch (Exception ex) {
//                    response = new ServerResponse("Authentication failed", 401, headers);
//                }
//            }
//
//        }
//
//        return response;
//    }
}
