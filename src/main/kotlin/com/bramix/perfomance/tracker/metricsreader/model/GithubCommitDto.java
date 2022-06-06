package com.bramix.perfomance.tracker.metricsreader.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class GithubCommitDto {
    AuthorDto author;
    CommitInfoDto committer;
    OwnerDto owner;
    Date commitDate;
    List<CommitFileDto> commitFiles;
}
