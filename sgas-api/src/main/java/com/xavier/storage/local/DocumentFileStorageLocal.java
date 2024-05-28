package com.xavier.storage.local;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;



@Path("/document-file")
public class DocumentFileStorageLocal {

    private static final Logger logger = Logger.getLogger(DocumentFileStorageLocal.class);

    private java.nio.file.Path local;
    private java.nio.file.Path temporaryLocal;

    @PostConstruct
    void init() {
        this.local = Paths.get(System.getProperty("user.home"), ".sgas");
        createLocalDirectories();
    }

    private void createLocalDirectories() {
        try {
            Files.createDirectories(this.local);
            this.temporaryLocal = this.local.resolve("temp");
            Files.createDirectories(this.temporaryLocal);

            logger.debugf("Pastas criadas para salvar fotos.");
            logger.debugf("Pasta default: %s", this.local.toAbsolutePath());
            logger.debugf("Pasta temporária: %s", this.temporaryLocal.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Erro criando pasta para salvar foto", e);
        }
    }

    private String renameFile(String originalName) {
        String newName = UUID.randomUUID().toString() + "_" + originalName;
        logger.debugf("Nome original: %s, novo nome: %s", originalName, newName);
        return newName;
    }

   
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/temporary")
    public Response saveTemporary(@MultipartForm MultipartFormDataInput input, @Context UriInfo uriInfo) {
        String newName = null;
        try {
            InputPart filePart = input.getFormDataMap().get("file").get(0);
            String fileName = filePart.getHeaders().getFirst("Content-Disposition").replaceAll("(?i).*filename=\"([^\"]+)\".*", "$1");
            InputStream fileInputStream = filePart.getBody(InputStream.class, null);

            newName = renameFile(fileName);
            Files.copy(fileInputStream, this.temporaryLocal.resolve(newName));
        } catch (IOException e) {
            throw new RuntimeException("Erro salvando a foto na pasta temporária", e);
        }

        return Response.ok(newName).build();
    }

    public byte[] retrieveTemporaryFile(String nome) {
        try {
            return Files.readAllBytes(this.temporaryLocal.resolve(nome));
        } catch (IOException e) {
            throw new RuntimeException("Erro lendo a foto temporária", e);
        }
    }
    
}
