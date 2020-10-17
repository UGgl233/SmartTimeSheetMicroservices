package com.smarttimesheet.timesheetserver.controller;

import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SummaryController {
    @Autowired
    private TimesheetService service;

    @GetMapping("/Summary")
    //return every week's summary
    //get the same name from several document and return it
    public List<Timesheet> getAll() {

        service.saveDocument();
        return service.findAll();

    }
}
