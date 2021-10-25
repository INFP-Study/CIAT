package com.infp.ciat.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@EnableConfigurationProperties
//@PropertySource("classpath:properties/key-${spring.profiles.active}.properties")
@PropertySource("classpath:properties/key-local.properties")
public class KeyProperties {

    @Value("${forest.serviceKey}")
    private String forestServiceKey;
}
