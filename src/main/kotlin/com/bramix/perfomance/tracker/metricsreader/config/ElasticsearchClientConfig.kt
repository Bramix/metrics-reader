package com.bramix.perfomance.tracker.metricsreader.config

import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
@ComponentScan(basePackages = ["com.bramix.perfomance.tracker.metricsreader"])
class ElasticsearchClientConfig {
    fun client(): RestHighLevelClient? {
        return RestHighLevelClient(
            RestClient.builder(HttpHost("localhost"))
        )
    }
}