package com.smarttimesheet.timesheetserver.controller;

import com.google.common.collect.Lists;
import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.domain.Details;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SummaryController {
    @Autowired
    private TimesheetService service;


    //return every week's summary
    //get the same name from several document and return it
//    public List<Timesheet> getAll(@RequestParam String name) {
//
//        service.saveDocument();
//        List<Timesheet> list = service.findByName("1");
//        System.out.println(list);
//        return service.findByName("1");
//
//    }

    @GetMapping("/Summary")
    public ResponseEntity<List<Timesheet>> findByName(@RequestParam String name) {
        //name = "1";
        service.saveDocument();
        List<Timesheet> list = service.findByName(name);
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    public List<Timesheet> findByName(@RequestParam String name){
//        service.saveDocument();
//        List<Timesheet> list = service.findByName(name);
//        System.out.println(list);
//
//        return list;
//    }


}
