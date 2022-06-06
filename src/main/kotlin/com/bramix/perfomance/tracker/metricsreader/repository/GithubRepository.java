package com.bramix.perfomance.tracker.metricsreader.repository;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Repository;


@AllArgsConstructor
@Repository
@Slf4j
public class GithubRepository {

    private final RestHighLevelClient restHighLevelClient;

    @SneakyThrows
    public void saveGithubReport(String content) {
        IndexRequest request = new IndexRequest("github_reports");
        request.source(content, XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        log.info("Response from elastic has been received", response);
    }
}
