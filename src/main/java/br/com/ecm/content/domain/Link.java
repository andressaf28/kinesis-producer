package br.com.ecm.content.domain;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Link {

    private UUID id;
    private UUID process;
    private Date creationDate;
    private List<Metadata> metadata;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProcess() {
        return process;
    }

    public void setProcess(UUID process) {
        this.process = process;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public Link(UUID id, UUID process, Date creationDate, List<Metadata> metadata) {
        this.id = id;
        this.process = process;
        this.creationDate = creationDate;
        this.metadata = metadata;
    }

    private final static ObjectMapper JSON = new ObjectMapper();
    static {
        JSON.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public byte[] toJsonAsBytes() {
        try {
            return JSON.writeValueAsBytes(this);
        } catch (IOException e) {
            return null;
        }
    }

    public static Metadata fromJsonAsBytes(byte[] bytes) {
        try {
            return JSON.readValue(bytes, Metadata.class);
        } catch (IOException e) {
            return null;
        }
    }
}
