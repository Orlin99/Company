package com.example.company.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginResourceSharingConfiguration implements WebMvcConfigurer {

  private static final String PATTERN_FOR_ALL_FRONT_END_API_ENDPOINTS = "/**";
  private static final String ALLOWED_ORIGINS = "http://localhost:5173";
  private static final String GET = "GET";
  private static final String POST = "POST";
  private static final String PUT = "PUT";
  private static final String PATCH = "PATCH";
  private static final String DELETE = "DELETE";
  private static final String OPTIONS = "OPTIONS";
  private static final String ALLOWED_ALL_HEADERS = "*";
  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final boolean CREDENTIALS_ALLOWEDMENT = false;
  private static final long MAX_AGE_ONE_HOUR = 3600L;

  // @formatter:off
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping(PATTERN_FOR_ALL_FRONT_END_API_ENDPOINTS)
            .allowedOrigins(ALLOWED_ORIGINS)
            .allowedMethods(GET, POST, PUT, PATCH, DELETE, OPTIONS)
            .allowedHeaders(ALLOWED_ALL_HEADERS)
            .exposedHeaders(AUTHORIZATION_HEADER, CONTENT_TYPE_HEADER)
            .allowCredentials(CREDENTIALS_ALLOWEDMENT)
            .maxAge(MAX_AGE_ONE_HOUR);
  }
  // @formatter:on
}
