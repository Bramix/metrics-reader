package com.bramix.perfomance.tracker.metricsreader.service;

import com.bramix.perfomance.tracker.metricsreader.model.GithubReport;
import com.bramix.perfomance.tracker.metricsreader.repository.ReportRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

@AllArgsConstructor
@Service
@Slf4j
public class JiraReportService {
    private final ObjectMapper objectMapper;
    private final ReportRepository reportRepository;

    @SneakyThrows
    public void saveReport(String reportDataJson) {
        Arrays.stream(objectMapper.readValue(reportDataJson, Map[].class))
                .forEach(reportItem -> {
                    try {
                        reportRepository.saveJiraReport(objectMapper.writeValueAsString(reportItem));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
