package com.bramix.perfomance.tracker.metricsreader.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
public class CommitFileDto {
    String status;
    Integer changesCount;
    Integer additionsCount;
    Integer deletionsCount;
    String url;
    String patch;
}
