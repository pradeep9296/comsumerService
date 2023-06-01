package com.consumer.comsumerService.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author prade on 01-06-2023
 */
@Data
@ConfigurationProperties("configuration")
@org.springframework.context.annotation.Configuration
public class Configuration {
    private String url;
}
