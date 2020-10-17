package com.smarttimesheet.smarttimesheetmainservice.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimeSheetEntity implements Serializable {
    private String empId;
    private String weekEnding;
}
