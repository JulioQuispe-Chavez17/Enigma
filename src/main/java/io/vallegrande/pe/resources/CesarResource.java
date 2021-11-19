package io.vallegrande.pe.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.vallegrande.pe.services.CesarService;

@Path("/cesar")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
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
        return Response.ok(service.decipher(message)).status(200).build();
    }

}
