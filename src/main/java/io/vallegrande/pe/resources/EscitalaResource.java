package io.vallegrande.pe.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.vallegrande.pe.services.EscitalaService;

@Path("/escitala")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class EscitalaResource {
    @Inject
    EscitalaService service;

    @POST
    @Path("/encrypt")
    public Response encrypts(@QueryParam("chain") String chain, @QueryParam("columns") Integer columns) {
        return Response.ok(service.encrypt(chain, columns)).status(200).build();
    }

    @POST
    @Path("/decipher")
    public Response deciphers(@QueryParam("chain") String chain, @QueryParam("columns") Integer columns) {
        return Response.ok(service.decipher(chain, columns)).status(200).build();
    }
}
