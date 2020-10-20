package com.smarttimesheet.timesheetserver.controller;

import com.smarttimesheet.timesheetserver.domain.Details;
import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.repository.TimeSheetMongoRepository;
import com.smarttimesheet.timesheetserver.service.TimesheetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/timeSheet")
public class TimesheetController {

    @Autowired
    private TimesheetService service;

    @Autowired
    private TimeSheetMongoRepository timeSheetMongoRepository;


    //get the details from several document
    @GetMapping("/Timesheet")
    public List<Details> getDeatilsByName(String name) {
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

    // @TEST purpose
    @GetMapping("/test")
    public Timesheet findTimeSheetById(@RequestParam String id) {
        Optional<Timesheet> timesheet = timeSheetMongoRepository.findById(id);
        if (timesheet.isPresent()) {
            Timesheet temp = timesheet.get();
            temp.setTotalHours(42);
            timeSheetMongoRepository.save(temp);
            return timesheet.get();
        }
        return null;
    }
}
