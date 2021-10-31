package com.infp.ciat.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Data
@Configuration
//@EnableConfigurationProperties
@ConfigurationProperties("forest")
public class ForestProperties {
    private String url;
    private String key;
}
