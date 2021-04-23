package com.example.home.MongoDB.Spring.Boot.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Data
@Component
@ConditionalOnClass({DummyConfiguration.class,DefaultExceptionThrowConfig.class})
@EnableConfigurationProperties({DummyConfiguration.class})
@AutoConfigureAfter({PriorityOneConfiguration.class})
@ConditionalOnProperty(value="app.name",havingValue = "SpringBootApp")
@ConditionalOnMissingBean({DummyBean.class})
@ConfigurationProperties(prefix = "app")
public class PropertiesConfiguration {
    private String name;
    private String designer;

    @Autowired
    DummyConfiguration dummyConfiguration;

}
