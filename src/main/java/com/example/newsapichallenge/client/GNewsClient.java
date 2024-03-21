package com.example.newsapichallenge.client;

import com.example.newsapichallenge.model.NewsSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "g-news-client",
        url = "${feign.client.url.gnews}",
        configuration = GNewsClientInterceptor.class)
public interface GNewsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v4/search?{searchParams}", consumes = "application/json")
    NewsSearchResponse getArticles(
            @PathVariable("searchParams") String searchParams);
}
