package com.smarttimesheet.timesheetserver.domain;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TimeSheetSummary")
@Builder
@Data
public class Details {
    private String date;
    private String day;
    private int startingTime;
    private int endingTime;
    private int totalHours;
}
