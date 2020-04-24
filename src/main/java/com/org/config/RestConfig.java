package com.org.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import org.hamcrest.Matcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

@Configuration
@ComponentScan(basePackages = "com.org")
@Getter
@Setter
public class RestConfig {

    @Value("${base_url}")
    private String baseUrl;

    /**
     * By adding session filter we reuse the same session filter instance to automatically apply
     * the session id from the previous response.
     * Jackson is used for serialization and deserialization
     */
    @Bean
    public RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new SessionFilter())
                .setConfig(jacksonConfig())
                .build();
    }

    /**
     * Configuring Jackson to fail on unknown properties.
     * This means that if a property exists in json and not in Java object, the deserialization will fail.
     */
    private RestAssuredConfig jacksonConfig() {
        return RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                        (cls, charset) -> {
                            ObjectMapper om = new ObjectMapper().findAndRegisterModules();
                            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                            return om;
                        }
                ));
    }
}
