package com.infp.ciat.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@EnableConfigurationProperties
public class UrlProperties {

    @Value("${forest.public}")
    private String publicUrl;

}
