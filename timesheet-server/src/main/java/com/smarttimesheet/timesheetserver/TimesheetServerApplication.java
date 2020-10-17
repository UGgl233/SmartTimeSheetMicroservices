package com.smarttimesheet.timesheetserver;

import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.repository.TimeSheetMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
 public class TimesheetServerApplication implements CommandLineRunner {


    @Autowired
    private TimeSheetMongoRepository repository;

    public static void main(String[] args) {
        System.out.println("test");
        SpringApplication.run(TimesheetServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("RUNUNUNRU");
        repository.deleteAll();
        repository.save(Timesheet.builder().name("Maggie").submissionStatus("Complete").
                approvalStatus("N/A").weekEnding("3/10/2018")
                .comment("1 Floating Day Required").build());
        repository.save(Timesheet.builder().name("Holiday").submissionStatus("Not Complete").
                approvalStatus("N/A").weekEnding("3/17/2018")
                .comment("1 Floating Day Required").build());

        // fetch all customers
        System.out.println("Employee found with findAll():");
        System.out.println("-------------------------------");
        for (Timesheet time : repository.findAll()) {
            System.out.println(time);
        }

        System.out.println();

        // fetch an individual customer
        System.out.println("Employee found with findByName:");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("Phillip"));
    }
}
