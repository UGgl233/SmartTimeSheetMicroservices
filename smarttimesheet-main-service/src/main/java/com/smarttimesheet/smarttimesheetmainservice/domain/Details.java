package com.smarttimesheet.smarttimesheetmainservice.domain;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class Details {
    private String date;
    private String day;
    private int startingTime;
    private int endingTime;
    private int totalHours;
}
