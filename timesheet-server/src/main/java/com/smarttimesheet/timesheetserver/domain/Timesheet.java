package com.smarttimesheet.timesheetserver.domain;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "TimeSheetSummary")
@Builder
@Data
public class Timesheet {
    @Id
    private String id;
    private String name;
    private String submissionStatus;
    private String approvalStatus;
    private String weekEnding;
    private String comment;
    private List<Details> details;
}
