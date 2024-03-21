package com.example.newsapichallenge.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author Surya Nedunuri.
 */
@Validated
@Getter
@ConfigurationProperties(prefix = "gnews.api")
@Setter
public class GNewsAuthConfigs {
    private String key;
}
