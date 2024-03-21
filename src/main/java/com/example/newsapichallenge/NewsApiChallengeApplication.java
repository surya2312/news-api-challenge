package com.example.newsapichallenge;

import com.example.newsapichallenge.client.NewsChallengeApplicationClients;
import com.example.newsapichallenge.config.GNewsAuthConfigs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main app for interacting with GNews API.
 *
 * @author Surya Nedunuri.
 */
@SpringBootApplication
@EnableFeignClients(basePackageClasses = NewsChallengeApplicationClients.class)
@EnableConfigurationProperties({GNewsAuthConfigs.class})
@EnableCaching
public class NewsApiChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsApiChallengeApplication.class, args);
    }

}
