package com.smarttimesheet.timesheetserver.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitListenerForTimeSheetCreate implements MessageListener {

    // Save Time Sheet to MongoDB
    @Override
    public void onMessage(Message message) {

        System.out.println("Received a new message = [" + new String(message.getBody()) + "]");
    }
}
