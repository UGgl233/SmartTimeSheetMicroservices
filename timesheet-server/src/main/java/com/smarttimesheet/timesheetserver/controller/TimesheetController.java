package com.smarttimesheet.timesheetserver.controller;

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
}
