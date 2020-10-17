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

        repository.deleteAll();

        repository.save(Timesheet.builder().name("1").totalHours(45).submissionStatus("Complete").
                approvalStatus("approved").weekEnding("3/17/2018").comment("1 Floating Day Required")
                .details(Arrays.asList(day1, day2, day3, day4, day5, day6, day7)).build());
        repository.save(Timesheet.builder().name("2").totalHours(40).submissionStatus("Not Complete").
                approvalStatus("N/A").weekEnding("3/10/2018").comment("1 Floating Day Required")
                .details(Arrays.asList(day1, day2, day3, day4, day5, day6, day7)).build());
        repository.save(Timesheet.builder().name("2").totalHours(35).submissionStatus("Not Complete").
                approvalStatus("N/A").weekEnding("3/03/2018").comment("1 Floating Day Required")
                .details(Arrays.asList(day1, day2, day3, day4, day5, day6, day7)).build());
        repository.save(Timesheet.builder().name("2").totalHours(36).submissionStatus("Not Complete").
                approvalStatus("N/A").weekEnding("2/25/2018").comment("1 Floating Day Required")
                .details(Arrays.asList(day1, day2, day3, day4, day5, day6, day7)).build());
        repository.save(Timesheet.builder().name("2").totalHours(40).submissionStatus("Not Complete").
                approvalStatus("N/A").weekEnding("2/18/2018").comment("1 Floating Day Required")
                .details(Arrays.asList(day1, day2, day3, day4, day5, day6, day7)).build());
        repository.save(Timesheet.builder().name("2").totalHours(40).submissionStatus("Not Complete").
                approvalStatus("N/A").weekEnding("2/11/2018").comment("1 Floating Day Required")
                .details(Arrays.asList(day1, day2, day3, day4, day5, day6, day7)).build());

    }

    //return all document
    public List<Timesheet> findAll(){ return repository.findAll(); }

    //return document by name
    public List<Timesheet> findByName(String name) {return repository.findByName(name);}

    //find details by name
//    public List<Details> findDetailsByName(String name) {
//        List<Details> list = new ArrayList<>();
//        repository.findByName("1").indexOf(Details.class);
//
//        return null;
//    }
}
