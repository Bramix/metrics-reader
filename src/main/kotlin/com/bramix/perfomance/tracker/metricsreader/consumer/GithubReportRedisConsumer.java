package com.bramix.perfomance.tracker.metricsreader.consumer;

import com.bramix.perfomance.tracker.metricsreader.service.GithubReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class GithubReportRedisConsumer implements StreamListener<String, ObjectRecord<String, String>> {

    private final GithubReportService githubReportService;

    @Override
    public void onMessage(ObjectRecord<String, String> message) {
        githubReportService.saveReport(message.getValue());
    }
}
