package com.org;

import com.org.config.PetStorePath;
import com.org.config.RestConfig;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = RestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {

    @Value("${proxy.enabled}")
    private boolean enableProxy;

    @Autowired
    protected RequestSpecification requestSpecification;

    @Autowired
    protected PetStorePath path;

    @BeforeAll
    void proxyConfig() {
        if (enableProxy) {
            System.setProperty("https.proxyHost", "seproxy.hm.com");
            System.setProperty("https.proxyPort", "8080");
        }
    }
}
