package com.example.FlightStatusApp.rabbitmq;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange flightStatusExchange() {
        return new TopicExchange("flightStatusExchange");
    }
    @Bean
    public Queue flightStatusQueue() {
        return new Queue("flightStatusQueue");
    }

}

