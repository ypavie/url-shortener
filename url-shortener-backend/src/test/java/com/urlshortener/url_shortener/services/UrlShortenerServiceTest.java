package com.urlshortener.url_shortener.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.security.SecureRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.urlshortener.url_shortener.models.UrlShortener;
import com.urlshortener.url_shortener.repository.UrlShortenerRepository;

@SpringBootTest
public class UrlShortenerServiceTest {

    @Mock
    private UrlShortenerRepository urlShortenerRepository;

    @InjectMocks
    private UrlShortenerService urlShortenerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShortUrl() {
        String originalUrl = "http://example.com";
        String shortUrl = "abc123";

        UrlShortener urlShortener = new UrlShortener();
        urlShortener.setUrl(originalUrl);
        urlShortener.setUrlShort(shortUrl);

        when(urlShortenerRepository.save(any(UrlShortener.class))).thenReturn(urlShortener);

        String result = urlShortenerService.shortUrl(originalUrl);
        assertEquals(shortUrl, result);
    }

    @Test
    public void testGetUrl() {
        String shortUrl = "abc123";
        String originalUrl = "http://example.com";

        UrlShortener urlShortener = new UrlShortener();
        urlShortener.setUrl(originalUrl);
        urlShortener.setUrlShort(shortUrl);

        when(urlShortenerRepository.findByUrlShort(shortUrl)).thenReturn(urlShortener);

        String result = urlShortenerService.getUrl(shortUrl);
        assertEquals(originalUrl, result);
    }
}
