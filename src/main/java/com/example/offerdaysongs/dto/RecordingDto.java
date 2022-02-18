package com.example.offerdaysongs.dto;

import com.example.offerdaysongs.model.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
public class RecordingDto {
    Long id;
    String title;
    String version;
    ZonedDateTime releaseTime;
    SingerDto singer;
    Set<Rule> rule;
}
