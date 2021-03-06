package com.smarttimesheet.smarttimesheetmainservice.entity;

import com.smarttimesheet.smarttimesheetmainservice.domain.Details;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimeSheetEntity implements Serializable {
    private String id;
    private String name;
    private String submissionStatus;
    private String approvalStatus;
    private String weekEnding;
    private int totalHours;
    private String comment;
    private List<Details> details;
}
