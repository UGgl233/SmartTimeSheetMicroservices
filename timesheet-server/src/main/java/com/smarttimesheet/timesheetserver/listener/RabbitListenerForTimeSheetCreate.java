package com.smarttimesheet.timesheetserver.listener;

import com.google.gson.Gson;
import com.netflix.discovery.converters.Auto;
import com.smarttimesheet.timesheetserver.domain.Timesheet;
import com.smarttimesheet.timesheetserver.repository.TimeSheetMongoRepository;
import com.smarttimesheet.timesheetserver.service.TimesheetService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

@Component
public class RabbitListenerForTimeSheetCreate implements MessageListener {

    @Autowired
    private TimeSheetMongoRepository timeSheetMongoRepository;

    @Autowired
    private TimesheetService timesheetService;

    // Save Time Sheet to MongoDB
    @Override
    public void onMessage(Message message) {
        Gson gson = new Gson();
        Timesheet timeSheetFromRabbiMQ = gson.fromJson(new String(message.getBody()),Timesheet.class);
//        System.out.println("Received a new message = [" + timeSheetFromRabbiMQ.toString() + "]");
        timesheetService.handleRabbitMQMessage(timeSheetFromRabbiMQ);
    }
}
