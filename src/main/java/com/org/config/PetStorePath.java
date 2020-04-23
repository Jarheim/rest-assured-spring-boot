package com.org.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("path.v2")
@EnableConfigurationProperties
@Getter
@Setter
public class PetStorePath {
    private String post;
    private String put;
    private String get;
    private String delete;
}
