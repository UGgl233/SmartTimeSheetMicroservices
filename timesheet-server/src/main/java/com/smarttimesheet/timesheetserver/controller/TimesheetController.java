package com.smarttimesheet.timesheetserver.controller;

import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.repository.TimeSheetMongoRepository;
import com.smarttimesheet.timesheetserver.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/timeSheet")
public class TimesheetController {
    @Autowired
    private TimesheetService service;

    @GetMapping("/Timesheet")
    public List<String> getUsersById() {

        service.saveDocument();
        List<String> data = new ArrayList<>();
        List<Timesheet> list = new ArrayList<>();
        for (Timesheet time : service.findByName("Phillip")) {
            list.add(time);
        }
        String submission = list.get(0).getSubmissionStatus();
        String approval = list.get(0).getApprovalStatus();
        String name = list.get(0).getName();

        data.add(submission);
        data.add(approval);
        data.add(name);
        return data;
    }

    // @PARAMS: Employee ID, starting week Ending
    @GetMapping("/fetchMostRecent5Sheets")
    public String fetchMostRecent5Sheets(@RequestParam String empId, @RequestParam String weekEnding) {
        // @TODO: Get most recent 5 sheets

        return "Got the most recent 5 sheets with empId: " + empId + " weekEnding: " + weekEnding;
    }
}
