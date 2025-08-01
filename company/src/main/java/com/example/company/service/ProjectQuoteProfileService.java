package com.example.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.company.dto.ProjectQuoteProfileDTO;
import com.example.company.model.ProjectQuoteProfile;
import com.example.company.repository.ProjectQuoteProfileRepository;
import com.example.company.utility.ProjectQuoteProfileUtility;

@Service
public class ProjectQuoteProfileService {

  private final ProjectQuoteProfileRepository projectQuoteProfileRepository;

  @Autowired
  public ProjectQuoteProfileService(ProjectQuoteProfileRepository projectQuoteProfileRepository) {
    this.projectQuoteProfileRepository = projectQuoteProfileRepository;
  }

  public void createProjectQuote(ProjectQuoteProfileDTO projectQuoteProfileDTO) {
    ProjectQuoteProfileUtility.validateProjectQuoteProfileData(projectQuoteProfileDTO);
    final ProjectQuoteProfile entity = ProjectQuoteProfileUtility.toEntity(projectQuoteProfileDTO);
    projectQuoteProfileRepository.save(entity);
  }

  public Page<ProjectQuoteProfile> listQuotes(int pageNumber, int pageSize) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    return projectQuoteProfileRepository.findAll(pageable);
  }
}
