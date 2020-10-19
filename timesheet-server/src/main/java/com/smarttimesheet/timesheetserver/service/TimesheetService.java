package com.smarttimesheet.timesheetserver.service;

import com.smarttimesheet.timesheetserver.domain.Details;
import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.repository.TimeSheetMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Random;

@Service
public class TimesheetService {
    @Autowired
    TimeSheetMongoRepository repository;

    //insert document into MongoDB
    public void saveDocument(){

        Details day1 = Details.builder().date("3/11/2018").day("Monday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day2 = Details.builder().date("3/12/2018").day("Tuesday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day3 = Details.builder().date("3/13/2018").day("Wednesday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day4 = Details.builder().date("3/14/2018").day("Thursday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day5 = Details.builder().date("3/15/2018").day("Friday").startingTime(9).endingTime(17).totalHours(18-9).build();
        Details day6 = Details.builder().date("3/16/2018").day("Saturday").startingTime(10).endingTime(19).totalHours(19-10).build();
        Details day7 = Details.builder().date("3/17/2018").day("Sunday").startingTime(8).endingTime(16).totalHours(16-8).build();

        Details day21 = Details.builder().date("3/4/2018").day("Monday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day22 = Details.builder().date("3/5/2018").day("Tuesday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day23 = Details.builder().date("3/6/2018").day("Wednesday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day24 = Details.builder().date("3/7/2018").day("Thursday").startingTime(9).endingTime(18).totalHours(18-9).build();
        Details day25 = Details.builder().date("3/8/2018").day("Friday").startingTime(9).endingTime(17).totalHours(18-9).build();
        Details day26 = Details.builder().date("3/9/2018").day("Saturday").startingTime(10).endingTime(19).totalHours(19-10).build();
        Details day27 = Details.builder().date("3/10/2018").day("Sunday").startingTime(8).endingTime(16).totalHours(16-8).build();
        //repository.deleteAll();

        repository.save(Timesheet.builder().name("uggl123@gmail.com").totalHours(45).submissionStatus("Complete").
                approvalStatus("approved").weekEnding("3/17/2018").comment("1 Floating Day Required")
                .details(Arrays.asList(day1, day2, day3, day4, day5, day6, day7)).build());
        repository.save(Timesheet.builder().name("uggl123@gmail.com").totalHours(40).submissionStatus("Not Complete").
                approvalStatus("N/A").weekEnding("3/10/2018").comment("1 Floating Day Required")
                .details(Arrays.asList(day21, day22, day23, day24, day25, day26, day27)).build());
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

    public List<Timesheet> findAll(){ return repository.findAll(); }


    public List<Timesheet> findByName(String name) {return repository.findByName(name);}


    public List<Details> findDetailsByName(String name) {
        List<Details> list = new ArrayList<>();
        List<Timesheet> temp = repository.findByName("1");
        for (Timesheet sheet: temp) {
            List<Details> temp1 = sheet.getDetails();
            System.out.println(temp1);
            for (Details detail: temp1) {
                list.add(detail);
            }
        }
        return list;
    }

    // @Author UGGL
    // Used for frontend details page which got all details for given name and weekending
    public List<Details> findDetailsByNameAndWeekEnding(String name, String weekEnding) {
        List<Timesheet> timeSheets = repository.findAllByWeekEndingAndName(weekEnding, name);
        // Supposed to have only one.
        return timeSheets.get(0).getDetails();
    }

    // @Author UGGL
    // Used for frontend details page and will return a random time sheet
    public List<Details> getRandomDetailByName(String name) {
        Random rand = new Random();
        List<Timesheet> timeSheets = repository.findByName(name);
        // Get a random detail from the time sheet
        return timeSheets.get(rand.nextInt(timeSheets.size())).getDetails();
    }
}
