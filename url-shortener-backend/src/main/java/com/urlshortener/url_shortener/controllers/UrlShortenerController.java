package com.urlshortener.url_shortener.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortener.url_shortener.services.UrlShortenerService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestParam String url) {
        try {
            String shortUrl = urlShortenerService.shortUrl(url);
            if (shortUrl != null) {
                return ResponseEntity.ok(Map.of("url", shortUrl));
            } else {
                return ResponseEntity.internalServerError().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{url}")
    public ResponseEntity<Map<String, String>> getUrl(@PathVariable("url") String shortUrl) {
        try {
            String originalUrl = urlShortenerService.getUrl(shortUrl);
            if (originalUrl != null) {
                return ResponseEntity.ok(Map.of("url", originalUrl));
            } else {
                return ResponseEntity.internalServerError().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
