package com.example.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.dto.ProjectQuoteProfileDTO;
import com.example.company.model.ProjectQuoteProfile;
import com.example.company.service.ProjectQuoteProfileService;
import com.example.company.utility.ProjectQuoteProfileUtility;

@RestController
@RequestMapping(path = "api/v1/project-quote")
public class ProjectQuoteProfileController {

  private final ProjectQuoteProfileService projectQuoteProfileService;

  @Autowired
  public ProjectQuoteProfileController(ProjectQuoteProfileService projectQuoteProfileService) {
    this.projectQuoteProfileService = projectQuoteProfileService;
  }

  @PostMapping(path = "/submit-details")
  public ResponseEntity<String> createProjectQuote(@RequestBody ProjectQuoteProfileDTO projectQuoteProfileDTO) {
    projectQuoteProfileService.createProjectQuote(projectQuoteProfileDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(ProjectQuoteProfileUtility.SUCCESSFULLY_CREATED_PROJECT_QUOTE_RESPONSE);
  }

  // @formatter:off
 @GetMapping(path = "/list-quotes")
 public ResponseEntity<Page<ProjectQuoteProfile>> listQuotes(
     @RequestParam(required = false, defaultValue = "0") int pageNumber,
     @RequestParam(required = false, defaultValue = "10") int pageSize) {
   return ResponseEntity.status(HttpStatus.OK).body(projectQuoteProfileService.listQuotes(pageNumber, pageSize));
 }
 // @formatter:on
}
