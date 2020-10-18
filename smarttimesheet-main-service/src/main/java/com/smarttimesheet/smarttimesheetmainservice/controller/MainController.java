package com.smarttimesheet.smarttimesheetmainservice.controller;

import com.google.gson.Gson;
import com.smarttimesheet.smarttimesheetmainservice.client.TimeSheetServerClient;
import com.smarttimesheet.smarttimesheetmainservice.entity.TimeSheetEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private TimeSheetServerClient timeSheetServerClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/hello")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Hello world");
    }


    // FeignClient template
    @GetMapping("/timeSheetServerFetchMostRecent5Sheets")
    public String callTimeSheetServerFetchMostRecent5Sheets(@RequestParam String empId,
                                                            @RequestParam String weekEnding) {
        // 测试在devices服务里面调用park服务的接口
        return timeSheetServerClient.timeSheetServerFetchMostRecent5Sheets(empId, weekEnding);
    }

    // RabbitMQ template
    @PostMapping(path= "/createNewTimeSheet", consumes = "application/json", produces = "application/json")
    public void createNewTimeSheet(@RequestBody TimeSheetEntity timeSheetEntity){
        System.out.println(timeSheetEntity.toString());
        Gson gson = new Gson();
        String timeSheetEntityJson = gson.toJson(timeSheetEntity);

        rabbitTemplate.convertAndSend("TimeSheetExchange",
                "timeSheetCreatorKey", timeSheetEntityJson);
    }
}
