package io.vallegrande.pe.resources;

import io.vallegrande.pe.services.ProductSystemService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class ProductSystemResource {
    @Inject
    ProductSystemService service;

    @POST
    @Path("/generate-key")
    public Response generateKey(@QueryParam("chain") String chain, @QueryParam("keyword") String keyword) {
        return Response.ok(service.generatedKey(chain, keyword)).status(200).build();
    }

    @POST
    @Path("/encrypt")
    public Response encrypts(@QueryParam("chain") String chain, @QueryParam("key") String key,
            @QueryParam("columns") Integer columns, @QueryParam("rotations") Integer rotations) {
        return Response.ok(service.encrypt(chain, key, columns, rotations)).status(200).build();
    }

    @POST
    @Path("/decipher")
    public Response deciphers(@QueryParam("chain") String chain, @QueryParam("key") String key,
            @QueryParam("columns") Integer columns, @QueryParam("rotations") Integer rotations) {
        return Response.ok(service.decoder(chain, key, columns, rotations)).status(200).build();
    }

}
