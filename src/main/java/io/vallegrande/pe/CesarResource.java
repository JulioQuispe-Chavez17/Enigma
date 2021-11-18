package io.vallegrande.pe;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/cesar")
public class CesarResource {

    @Inject
    CesarService service;

    @POST
    @Path("/encrypt")
    public Response encrypts(@QueryParam("message") String message) {
        return Response.ok(service.encrypt(message)).status(200).build();
    }

    @POST
    @Path("/decipher")
    public Response deciphers(@QueryParam("message") String message) {
        return Response.ok(service.decipher(message)).status(201).build();
    }

    
}
