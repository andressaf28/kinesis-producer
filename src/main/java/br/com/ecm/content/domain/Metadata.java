package br.com.ecm.content.domain;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Metadata {
    private String code;
    private String value;
    private final static ObjectMapper JSON = new ObjectMapper();

    static {
        JSON.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Metadata(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
