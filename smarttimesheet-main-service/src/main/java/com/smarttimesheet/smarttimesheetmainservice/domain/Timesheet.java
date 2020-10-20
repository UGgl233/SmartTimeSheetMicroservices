package com.smarttimesheet.smarttimesheetmainservice.domain;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
@Data
public class Timesheet {
    private String id;
    private String name;
    private String submissionStatus;
    private String approvalStatus;
    private String weekEnding;
    private int totalHours;
    private String comment;
    private List<Details> details;
}
