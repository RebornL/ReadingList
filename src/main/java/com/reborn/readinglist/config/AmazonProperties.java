package com.reborn.readinglist.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")//springboot1.5以上要加上
@ConfigurationProperties("amazon")
public class AmazonProperties {

    private String associatedId;

    public void setAssociatedId(String associatedId) {
        this.associatedId = associatedId;
    }

    public String getAssociatedId() {
        return associatedId;
    }
}
