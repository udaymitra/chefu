package com.chefu.configuration;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ChefuConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    @NotEmpty
    public String mongohost = "localhost";

    @Min(1)
    @Max(65535)
    @JsonProperty
    public int mongoport = 27017;

    @JsonProperty
    @NotEmpty
    public String mongodb = "UserAccount";


    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    public String getMongohost() {
        return mongohost;
    }

    public void setMongohost(String mongohost) {
        this.mongohost = mongohost;
    }

    public int getMongoport() {
        return mongoport;
    }

    public void setMongoport(int mongoport) {
        this.mongoport = mongoport;
    }

    public String getMongodb() {
        return mongodb;
    }

    public void setMongodb(String mongodb) {
        this.mongodb = mongodb;
    }
}
