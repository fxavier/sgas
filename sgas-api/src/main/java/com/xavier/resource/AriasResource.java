package com.xavier.resource;

import com.xavier.dto.AriasDTO;
import com.xavier.service.AriasService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/arias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AriasResource {

    @Inject
    AriasService ariasService;

    @POST
    public Response create(AriasDTO ariasDTO) {
        ariasService.create(ariasDTO);
        return Response.status(Response.Status.CREATED)
                        .entity(ariasDTO)
                        .build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, AriasDTO ariasDTO) {
        ariasService.update(id, ariasDTO);
        return Response.ok(ariasDTO)
                        .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(ariasService.findAll())
                        .build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(ariasService.findById(id))
                        .build();
    }

    @GET
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        ariasService.delete(id);
        return Response.noContent()
                        .build();
    }
    
}
