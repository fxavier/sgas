package com.xavier.storage.local;

import java.io.InputStream;

import org.jboss.resteasy.annotations.providers.multipart.PartFilename;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;

public class FileUploadForm {
    
    @FormParam("file")
    @PartFilename("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    public String fileName;

    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream fileData;

    @FormParam("fileType")
    @PartType(MediaType.TEXT_PLAIN)
    public String fileType;
}
