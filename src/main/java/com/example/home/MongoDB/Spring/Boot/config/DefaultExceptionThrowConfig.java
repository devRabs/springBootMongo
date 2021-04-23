package com.example.home.MongoDB.Spring.Boot.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter({PriorityOneConfiguration.class})
@ConfigurationProperties(prefix = "app.default.exception")
public class DefaultExceptionThrowConfig {
    private String throwableCondition;

    public String getThrowableCondition() {
        return throwableCondition;
    }

    public void setThrowableCondition(String throwableCondition) {
        this.throwableCondition = throwableCondition;
    }
}
