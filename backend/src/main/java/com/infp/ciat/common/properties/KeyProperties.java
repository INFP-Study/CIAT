package com.infp.ciat.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties
public class KeyProperties {

    @Value("${forest.serviceKey}")
    private String forestServiceKey;
}
