package com.smarttimesheet.smarttimesheetmainservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "timesheet-server")
public interface TimeSheetServerClient {
    @GetMapping("/timeSheet/fetchMostRecent5Sheets")
    String timeSheetServerFetchMostRecent5Sheets(@RequestParam String empId, @RequestParam String weekEnding);
}
