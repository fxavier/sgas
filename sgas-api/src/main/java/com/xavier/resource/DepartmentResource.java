package com.xavier.resource;

import com.xavier.dto.DepartmentDTO;
import com.xavier.service.DepartmentService;

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

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    DepartmentService departmentService;

    @POST
    public Response create(DepartmentDTO departmentDTO) {
        DepartmentDTO department = departmentService.create(departmentDTO);
        return Response.status(Response.Status.CREATED).entity(department).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(departmentService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(departmentService.findById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, DepartmentDTO departmentDTO) {
        DepartmentDTO department = departmentService.update(id, departmentDTO);
        return Response.ok(department).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        departmentService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
