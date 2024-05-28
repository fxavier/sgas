package com.xavier.resource;

import com.xavier.dto.DocumentDTO;
import com.xavier.service.DocumentService;

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

@Path("/api/v1/documents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentResource {

    @Inject
    DocumentService documentService;

    @POST
    public Response createDocument(DocumentDTO documentDTO) {
        DocumentDTO created = documentService.create(documentDTO);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDocument(@PathParam("id") Long id, DocumentDTO documentDTO) {
        documentDTO.setId(id);
        DocumentDTO updated = documentService.update(documentDTO);
        return Response.status(Response.Status.OK).entity(updated).build();
        
    }

    @GET
    @Path("/{id}")
    public Response getDocument(@PathParam("id") Long id) {
        DocumentDTO document = documentService.findById(id);
        if (document == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(document).build();
    }

    @GET
    public Response getDocuments() {
        return Response.status(Response.Status.OK).entity(documentService.findAll()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDocument(@PathParam("id") Long id) {
        documentService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
