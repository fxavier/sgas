package com.xavier.resource;

import com.xavier.dto.DocumentTypeDTO;
import com.xavier.service.DocumentTypeService;

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

@Path("/api/v1/document-types")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentTypeResource {

    @Inject
    DocumentTypeService documentTypeService;

    @POST
    public Response createDocumentType(DocumentTypeDTO documentTypeDTO) {
        DocumentTypeDTO created = documentTypeService.create(documentTypeDTO);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDocumentType(@PathParam("id") Long id, DocumentTypeDTO documentTypeDTO) {
        documentTypeDTO.setId(id);
        DocumentTypeDTO updated = documentTypeService.update(documentTypeDTO);
        return Response.status(Response.Status.OK).entity(updated).build();
        
    }

    @GET
    @Path("/{id}")
    public Response getDocumentType(@PathParam("id") Long id) {
        DocumentTypeDTO documentType = documentTypeService.findById(id);
        if (documentType == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(documentType).build();
    }

    @GET
    public Response getDocumentTypes() {
        return Response.status(Response.Status.OK).entity(documentTypeService.findAll()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDocumentType(@PathParam("id") Long id) {
        documentTypeService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
