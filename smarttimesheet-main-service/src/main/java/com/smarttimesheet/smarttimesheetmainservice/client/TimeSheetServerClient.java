package com.smarttimesheet.smarttimesheetmainservice.client;

import com.smarttimesheet.smarttimesheetmainservice.domain.Details;
import com.smarttimesheet.smarttimesheetmainservice.domain.Timesheet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "timesheet-server")
public interface TimeSheetServerClient {
    @GetMapping("/timeSheet/fetchMostRecent5Sheets")
    String timeSheetServerFetchMostRecent5Sheets(@RequestParam String empId, @RequestParam String weekEnding);

    @GetMapping("/api/Summary")
    ResponseEntity<List<Timesheet>> findSummaryOfTimeSheetByName(@RequestParam String name);

    @GetMapping("/timeSheet/details")
    List<Details> getDetailsByNameAndWeekending(@RequestParam String name,
                                                       @RequestParam String weekEnding);

    @GetMapping("/timeSheet/randomOneDetails")
    List<Details> getRandomDetailByName(@RequestParam String name);
}