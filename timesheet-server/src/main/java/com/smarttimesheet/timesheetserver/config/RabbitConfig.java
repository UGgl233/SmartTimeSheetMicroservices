package com.smarttimesheet.timesheetserver.config;

import com.smarttimesheet.timesheetserver.listener.RabbitListenerForTimeSheetCreate;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private static final String TIME_SHEET_CREATOR_QUEUE = "TimeSheetCreatorQueue";
    private static final String TIME_SHEET_EXCHANGE = "TimeSheetExchange";
    private static final String TIME_SHEET_ROUTING_KEY = "timeSheetCreatorKey";

    @Bean
    Queue myTimeSheetQueue() {
        return QueueBuilder.durable(TIME_SHEET_CREATOR_QUEUE)
                .autoDelete()
                .build();
    }

    @Bean
    Exchange myTimeSheetExchange() {
        return ExchangeBuilder.topicExchange(TIME_SHEET_EXCHANGE)
                .autoDelete()
                .durable(true)
                .build();
    }

    @Bean
    Binding queueBinding() {
        //return new Binding(TEST_QUEUE, Binding.DestinationType.QUEUE, TEST_EXCHANGE, "simple", null);
        return BindingBuilder
                .bind(myTimeSheetQueue())
                .to(myTimeSheetExchange())
                .with(TIME_SHEET_ROUTING_KEY)
                .noargs();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myTimeSheetQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitListenerForTimeSheetCreate());
        return simpleMessageListenerContainer;
    }
}
