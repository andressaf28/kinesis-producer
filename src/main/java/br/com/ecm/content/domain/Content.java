package br.com.ecm.content.domain;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Content {

    private List<Metadata> metadata;
    private List<Link> links;
    private Integer type;
    private String state;
    private String category;
    private UUID id;
    private Integer version;
    private Date creationDate;
    private Date updateDate;
    private Date expirationDate;

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Content(List<Metadata> metadata, List<Link> links, Integer type, String state, String category, UUID id, Integer version, Date criationDate, Date updateDate, Date expirationDate) {
        this.metadata = metadata;
        this.links = links;
        this.type = type;
        this.state = state;
        this.category = category;
        this.id = id;
        this.version = version;
        this.creationDate = criationDate;
        this.updateDate = updateDate;
        this.expirationDate = expirationDate;
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
