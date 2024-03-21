package com.example.newsapichallenge.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class NewsSearchResponse {

    private final Long totalArticles;
    private final List<Article> articles;
}
