package com.bramix.perfomance.tracker.metricsreader.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommitInfoDto {
    String message;
    Integer commentCount;
    String committerName;
    String committerEmail;
}
