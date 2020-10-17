package com.smarttimesheet.timesheetserver.service;

import com.smarttimesheet.timesheetserver.domain.Details;
import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.repository.TimeSheetMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TimesheetService {
    @Autowired
    TimeSheetMongoRepository repository;

    //insert document into MongoDB
    public void saveDocument(){

        Details day1 = Details.builder().day("Monday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day2 = Details.builder().day("Tuesday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day3 = Details.builder().day("Wednesday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day4 = Details.builder().day("Thursday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day5 = Details.builder().day("Friday").startingTime(9).endingTime(17).totalHours(18-9).build();
        Details day6 = Details.builder().day("Saturday").startingTime(-1).endingTime(-1).totalHours(0).build();
        Details day7 = Details.builder().day("Sunday").startingTime(-1).endingTime(-1).totalHours(0).build();

//        Details Phillip = null;
//        Phillip.builder().date("Monday").startingTime(9).endingTime(18).build();
//
//        Details Grace = null;
//        Grace.builder().date("Tuesday").startingTime(9).endingTime(18).build();


        repository.save(Timesheet.builder().name("Phillip").submissionStatus("Complete").
                approvalStatus("N/A").weekEnding("3/10/2018")
                .comment("1 Floating Day Required").details(Arrays.asList(day1)).build());
        repository.save(Timesheet.builder().name("Grace").submissionStatus("Not Complete").
                approvalStatus("N/A").weekEnding("3/17/2018")
                .comment("1 Floating Day Required").build());
    }

    //return all document
    public List<Timesheet> findAll(){ return repository.findAll(); }

    //return document by name
    public List<Timesheet> findByName(String name) {return repository.findByName(name);}
}
