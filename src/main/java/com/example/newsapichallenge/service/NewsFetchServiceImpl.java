package com.example.newsapichallenge.service;

import com.example.newsapichallenge.client.GNewsClient;
import com.example.newsapichallenge.model.NewsSearchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of NewsFetchService.
 *
 * @author Surya Nedunuri.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class NewsFetchServiceImpl implements NewsFetchService {

    private final GNewsClient gNewsClient;

    @Override
    @Cacheable("articlesCache")
    public NewsSearchResponse searchNewsArticles(String q, String lang, String country, int max, String in, String nullable,
                                                 String from, String to, int page, String expand) {

        log.info("Setting parameters to default");
        List<String> searchParams = new ArrayList<>();
        if (q != null) {
            searchParams.add("q=" + encodeValue(q));
        }
        if (lang != null) {
            searchParams.add("lang=" + encodeValue(lang));
        }
        if (country != null) {
            searchParams.add("country=" + encodeValue(country));
        }
        if (in != null) {
            searchParams.add("in=" + encodeValue(in));
        }
        if (nullable != null) {
            searchParams.add("nullable=" + encodeValue(nullable));
        }
        if (from != null) {
            searchParams.add("from=" + encodeValue(from));
        }
        if (to != null) {
            searchParams.add("to=" + encodeValue(to));
        }
        if (expand != null) {
            searchParams.add("expand=" + encodeValue(expand));
        }
        searchParams.add("max=" + max);
        searchParams.add("page=" + page);

        String searchParamsQuery = flattenList(searchParams);

        log.info("Call G news Feign client to get Articles with Search Params: {}", searchParamsQuery);

        return gNewsClient.getArticles(searchParamsQuery);
    }

    private static String encodeValue(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    public static String flattenList(List<String> stringList) {
        StringBuilder builder = new StringBuilder();
        for (String str : stringList) {
            if (!builder.isEmpty()) {
                builder.append("&");
            }
            builder.append(str);
        }
        return builder.toString();
    }
}
