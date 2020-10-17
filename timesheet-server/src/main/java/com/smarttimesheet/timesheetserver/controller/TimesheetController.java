package com.smarttimesheet.timesheetserver.controller;

import com.smarttimesheet.timesheetserver.domain.Details;
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

    //get the details from several document
    @GetMapping("/Timesheet")
    public List<Details> getDeatilsByName() {

        service.saveDocument();
//        List<String> data = new ArrayList<>();
//        List<Timesheet> list = new ArrayList<>();
//        for (Timesheet time : service.findByName("1")) {
//            list.add(time);
//        }
//        String submission = list.get(0).getSubmissionStatus();
//        String approval = list.get(0).getApprovalStatus();
//        String name = list.get(0).getName();
//        String details = list.get(0).getDetails().toString();
//
//        data.add(submission);
//        data.add(approval);
//        data.add(name);
//        data.add(details);
        //this list is used to stored the time sheet that matches the people.
        List<Timesheet> sheet = new ArrayList<>();
        List<Details> list = new ArrayList<>();
        for (Timesheet time: service.findByName("1")){
            sheet.add(time);
        }
        //add all the details from several timesheet into the list.
        return null;
    }

    // @PARAMS: Employee ID, starting week Ending
    @GetMapping("/fetchMostRecent5Sheets")
    public String fetchMostRecent5Sheets(@RequestParam String empId, @RequestParam String weekEnding) {
        // @TODO: Get most recent 5 sheets

        return "Got the most recent 5 sheets with empId: " + empId + " weekEnding: " + weekEnding;
    }
}
