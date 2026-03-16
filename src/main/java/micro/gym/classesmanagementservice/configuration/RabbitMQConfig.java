package micro.gym.classesmanagementservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "class-schedule-exchange";
    public static final String QUEUE    = "class-schedule-queue";
    public static final String ROUTING  = "class-schedule-routingkey";

    @Bean
    public FanoutExchange clasesExchange() {
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    public Queue clasesHorarioQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding binding(Queue clasesHorarioQueue, FanoutExchange clasesExchange) {
        return BindingBuilder.bind(clasesHorarioQueue).to(clasesExchange);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
