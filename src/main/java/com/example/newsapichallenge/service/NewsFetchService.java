package com.example.newsapichallenge.service;

import com.example.newsapichallenge.model.NewsSearchResponse;

/**
 * Service to handle Search requests to get News from GNews API
 *
 * @author Surya Nedunuri.
 */
public interface NewsFetchService {
    NewsSearchResponse searchNewsArticles(String q, String lang, String country, int max, String in, String nullable,
                                          String from, String to, int page, String expand);
}
