package com.example.newsapichallenge.web.controller;

import com.example.newsapichallenge.model.NewsSearchResponse;
import com.example.newsapichallenge.service.NewsFetchService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * RestController to manage Search Handlers for Fetch Api.
 *
 * @author Surya Nedunuri.
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class NewsApiChallengeController {

    private final NewsFetchService newsFetchService;

    @GetMapping(path = {"articles/v1"}, produces = "application/json")
    public NewsSearchResponse getNewsArticles(HttpServletRequest request,
                                              @RequestParam String q,
                                              @RequestParam(required = false) String lang,
                                              @RequestParam(required = false) String country,
                                              @RequestParam(defaultValue = "10") int max,
                                              @RequestParam(required = false) String in,
                                              @RequestParam(required = false) String nullable,
                                              @RequestParam(required = false) String from,
                                              @RequestParam(required = false) String to,
                                              @RequestParam(defaultValue = "1") int page,
                                              @RequestParam(required = false) String expand) throws BadRequestException {
        log.info("Received parameters: q=" + q + ", lang=" + lang + ", country=" + country +
                ", max=" + max + ", in=" + in + ", nullable=" + nullable +
                ", from=" + from + ", to=" + to +
                ", page=" + page + ", expand=" + expand);

        if (Objects.isNull(q)) {
            throw new BadRequestException("Search String q is Mandatory");
        }
        NewsSearchResponse results = newsFetchService.searchNewsArticles(q, lang,
                country, max, in, nullable, from, to, page, expand);
        log.info("Returning Results: {}", results);

        return results;
    }

}
