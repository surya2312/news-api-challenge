package com.example.newsapichallenge.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Article {

    private final String title;
    private final String description;
    private final String content;
    private final String url;
    private final String image;
    private final String publishedAt;
    private final ArticleSource source;

}
