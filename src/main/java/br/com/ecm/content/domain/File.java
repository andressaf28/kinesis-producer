package br.com.ecm.content.domain;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.UUID;

public class File {

    private UUID id;
    private String description;
    private Integer section;
    private String location;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public File(UUID id, String description, Integer section, String location) {
        this.id = id;
        this.description = description;
        this.section = section;
        this.location = location;
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
