package com.bramix.perfomance.tracker.metricsreader.service;

import com.bramix.perfomance.tracker.metricsreader.model.GithubReport;
import com.bramix.perfomance.tracker.metricsreader.repository.GithubRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GithubReportService {
    private final ObjectMapper objectMapper;
    private final GithubRepository githubRepository;

    @SneakyThrows
    public void saveReport(String reportDataJson) {
        objectMapper.readValue(reportDataJson, GithubReport.class).getGhCommits()
                .forEach(reportItem -> {
                    try {
                        githubRepository.saveGithubReport(objectMapper.writeValueAsString(reportItem));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
