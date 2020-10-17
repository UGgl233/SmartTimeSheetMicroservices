package com.smarttimesheet.timesheetserver.controller;

import com.smarttimesheet.timesheetserver.domain.Details;
import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.repository.TimeSheetMongoRepository;
import com.smarttimesheet.timesheetserver.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TimesheetController {
    @Autowired
    private TimesheetService service;

    //get the details from several document
    @GetMapping("/Timesheet")
    public List<Timesheet> getDeatilsByName() {

        //service.saveDocument();
        List<Timesheet> sheet = new ArrayList<>();
        //List<Details> list = new ArrayList<>();
        for (Timesheet time: service.findByName("1")){
            sheet.add(time);
        }
        //add all the details from several timesheet into the list.
        return sheet;
    }
}
