package com.bramix.perfomance.tracker.metricsreader.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OwnerDto {
    String name;
    String fullName;
    String language;
    String visibility;
}
