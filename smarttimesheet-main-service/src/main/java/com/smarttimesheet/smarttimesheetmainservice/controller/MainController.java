package com.smarttimesheet.smarttimesheetmainservice.controller;

import com.google.gson.Gson;
import com.smarttimesheet.smarttimesheetmainservice.client.TimeSheetServerClient;
import com.smarttimesheet.smarttimesheetmainservice.client.UserServerClinet;
import com.smarttimesheet.smarttimesheetmainservice.domain.Details;
import com.smarttimesheet.smarttimesheetmainservice.domain.Timesheet;
import com.smarttimesheet.smarttimesheetmainservice.entity.TimeSheetEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private TimeSheetServerClient timeSheetServerClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserServerClinet userServerClinet;

    private static final Logger logger = LogManager.getLogger(MainController.class);

    @GetMapping("/hello")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Hello world");
    }

    // FeignClient template for user
    @GetMapping("/loginAuthenticate")
    public boolean callAuthenticateUser(String email, String password) {
        return userServerClinet.authenticateUser(email, password);
    }

    // FeignClient template for timeSheet
    @GetMapping("/findSummaryOfTimeSheetByName")
    public ResponseEntity<List<Timesheet>> callFindSummaryOfTimeSheetByName(@RequestParam String name) {
        return timeSheetServerClient.findSummaryOfTimeSheetByName(name);
    }

    @GetMapping("/fetchTimeSheetDetails")
    public List<Details> callGetDetailsByNameAndWeekending(@RequestParam String name,
                                                       @RequestParam String weekEnding) {
        return timeSheetServerClient.getDetailsByNameAndWeekending(name, weekEnding);
    }

    @GetMapping("/fetchOneRandomTimeSheetDetails")
    public List<Details> callGetRandomDetailByName(@RequestParam String name) {
        return timeSheetServerClient.getRandomDetailByName(name);
    }

    @GetMapping("/timeSheetServerFetchMostRecent5Sheets")
    public String callTimeSheetServerFetchMostRecent5Sheets(@RequestParam String empId,
                                                            @RequestParam String weekEnding) {
        return timeSheetServerClient.timeSheetServerFetchMostRecent5Sheets(empId, weekEnding);
    }

    // RabbitMQ template
    // Not Used
    @PostMapping(path= "/createNewTimeSheet", consumes = "application/json", produces = "application/json")
    public void createNewTimeSheet(@RequestBody TimeSheetEntity timeSheetEntity){
        System.out.println(timeSheetEntity.toString());
        Gson gson = new Gson();
        String timeSheetEntityJson = gson.toJson(timeSheetEntity);

        rabbitTemplate.convertAndSend("TimeSheetExchange",
                "timeSheetCreatorKey", timeSheetEntityJson);
    }

    @PostMapping(path= "/editNewTimeSheet", consumes = "application/json", produces = "application/json")
    public void editNewTimeSheet(@RequestBody TimeSheetEntity timeSheetEntity){
//        System.out.println(timeSheetEntity.toString());
        Gson gson = new Gson();
        String timeSheetEntityJson = gson.toJson(timeSheetEntity);

        rabbitTemplate.convertAndSend("TimeSheetExchange",
                "timeSheetCreatorKey", timeSheetEntityJson);
    }
}
