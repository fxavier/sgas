package com.xavier.resource;


import java.util.List;

import com.xavier.dto.RisksAndImpactsDTO;
import com.xavier.service.RisksAndImpactService;

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

@Path("/risks-and-impact")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RisksAndImpact {

    @Inject
    RisksAndImpactService risksAndImpactService;

    @POST
    public Response create(RisksAndImpactsDTO risksAndImpactsDTO) {
        return Response.status(Response.Status.CREATED)
                       .entity(risksAndImpactService.create(risksAndImpactsDTO))
                       .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, RisksAndImpactsDTO risksAndImpactsDTO) {
        return Response.ok(risksAndImpactService.update(id, risksAndImpactsDTO)).build();
    }

    @GET
    public List<RisksAndImpactsDTO> findAll() {
        return risksAndImpactService.findAll();
    }

    @GET
    @Path("/{id}")
    public RisksAndImpactsDTO findById(@PathParam("id") Long id) {
        return risksAndImpactService.findById(id);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        risksAndImpactService.delete(id);
        return Response.noContent().build();
    }
    
}
