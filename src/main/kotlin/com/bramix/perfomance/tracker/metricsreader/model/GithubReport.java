package com.bramix.perfomance.tracker.metricsreader.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class GithubReport implements Serializable {
    List<GithubCommitDto> ghCommits;
}
