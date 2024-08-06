package com.urlshortener.url_shortener.controllers;

import com.urlshortener.url_shortener.services.UrlShortenerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

import static org.mockito.Mockito.when;

public class UrlShortenerControllerTest {

    @Mock
    private UrlShortenerService urlShortenerService;

    @InjectMocks
    private UrlShortenerController urlShortenerController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(urlShortenerController).build();
    }

    @Test
    public void testShortenUrl_Success() throws Exception {
        String originalUrl = "http://example.com";
        String shortUrl = "shortUrl";
        when(urlShortenerService.shortUrl(originalUrl)).thenReturn(shortUrl);

        mockMvc.perform(MockMvcRequestBuilders.get("/")
                .param("url", originalUrl))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.url").value(shortUrl));
    }

    @Test
    public void testShortenUrl_Failure() throws Exception {
        String originalUrl = "http://example.com";
        when(urlShortenerService.shortUrl(originalUrl)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/")
                .param("url", originalUrl))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    public void testGetUrl_Success() throws Exception {
        String shortUrl = "shortUrl";
        String originalUrl = "http://example.com";
        when(urlShortenerService.getUrl(shortUrl)).thenReturn(originalUrl);

        mockMvc.perform(MockMvcRequestBuilders.get("/{url}", shortUrl))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.url").value(originalUrl));
    }

    @Test
    public void testGetUrl_Failure() throws Exception {
        String shortUrl = "shortUrl";
        when(urlShortenerService.getUrl(shortUrl)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/{url}", shortUrl))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
