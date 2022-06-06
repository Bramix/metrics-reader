package com.bramix.perfomance.tracker.metricsreader.consumer;

import com.bramix.perfomance.tracker.metricsreader.service.JiraReportService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

@Service
@Slf4j
@AllArgsConstructor
public class JiraReportRedisConsumer implements StreamListener<String, ObjectRecord<String, String>> {

    private final ReactiveRedisTemplate<String, String> redisTemplate;
    private final JiraReportService jiraReportService;

    @Override
    @SneakyThrows
    public void onMessage(ObjectRecord<String, String> record) {
        log.info(InetAddress.getLocalHost().getHostName() + " - consumed :" + record.getValue());
        jiraReportService.saveReport(record.getValue());
    }

}
