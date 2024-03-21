package com.example.newsapichallenge.client;

import com.example.newsapichallenge.config.GNewsAuthConfigs;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Slf4j
public class GNewsClientInterceptor implements RequestInterceptor {

    private final GNewsAuthConfigs authConfig;

    @SneakyThrows
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.uri(URLDecoder.decode(requestTemplate.request().url(), StandardCharsets.UTF_8));
        requestTemplate.query("apikey", authConfig.getKey());
    }
}
