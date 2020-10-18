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
    public List<Details> getDeatilsByName(String name) {
        //service.saveDocument();
        //List<Details> list = new ArrayList<>();
        //service.findDetailsByName("1");
        //add all the details from several timesheet into the list.
        return service.findDetailsByName("1");
    }

    // Get the details of a timeSheet by name and weekending
    @GetMapping("/details")
    public List<Details> getDetailsByNameAndWeekending(@RequestParam String name,
                                                       @RequestParam String weekEnding) {
        return service.findDetailsByNameAndWeekEnding(name, weekEnding);
    }

    // Get a random timeSheet details
    @GetMapping("/randomOneDetails")
    public List<Details> getRandomDetailByName(@RequestParam String name) {
        return service.getRandomDetailByName(name);
    }

    // @PARAMS: Employee ID, starting week Ending
    @GetMapping("/fetchMostRecent5Sheets")
    public String fetchMostRecent5Sheets(@RequestParam String empId, @RequestParam String weekEnding) {
        // @TODO: Get most recent 5 sheets

        return "Got the most recent 5 sheets with empId: " + empId + " weekEnding: " + weekEnding;
    }
}
