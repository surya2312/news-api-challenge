package com.example.newsapichallenge.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ArticleSource {

    private final String name;
    private final String url;
}
