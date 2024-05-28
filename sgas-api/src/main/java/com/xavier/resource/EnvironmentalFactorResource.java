package com.xavier.resource;

import com.xavier.dto.EnvironmentalFactorDTO;
import com.xavier.service.EnvironmentalFactorService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/environmental-factors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnvironmentalFactorResource {

    @Inject
    EnvironmentalFactorService environmentalFactorService;

    @POST
    public Response create(EnvironmentalFactorDTO environmentalFactorDTO) {
        return Response.status(Response.Status.CREATED)
                .entity(environmentalFactorService.create(environmentalFactorDTO))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EnvironmentalFactorDTO environmentalFactorDTO) {
        return Response.status(Response.Status.OK)
                .entity(environmentalFactorService.update(id, environmentalFactorDTO))
                .build();
    }

    @GET
    public Response findAll() {
        return Response.status(Response.Status.OK)
                .entity(environmentalFactorService.findAll())
                .build();
    }

    @GET   
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK)
                .entity(environmentalFactorService.findById(id))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        environmentalFactorService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
