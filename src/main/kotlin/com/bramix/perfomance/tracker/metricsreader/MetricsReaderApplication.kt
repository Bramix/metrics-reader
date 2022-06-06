package com.bramix.perfomance.tracker.metricsreader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MetricsReaderApplication

fun main(args: Array<String>) {
	runApplication<MetricsReaderApplication>(*args)
}
