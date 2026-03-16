package micro.gym.classesmanagementservice.service;

import micro.gym.classesmanagementservice.dto.ClassScheduleEventDTO;
import micro.gym.classesmanagementservice.model.Class;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import micro.gym.classesmanagementservice.configuration.RabbitMQConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassScheduleProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishScheduleChange(Class gymClass) {
        ClassScheduleEventDTO event = new ClassScheduleEventDTO(
                gymClass.getId().getClassId_value(),
                gymClass.getName(),
                gymClass.getTrainerId().getTrainerId_value(),
                gymClass.getScheduleStart().getScheduleStart_value(),
                gymClass.getScheduleEnd().getScheduleEnd_value()
        );
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "", event);
        System.out.println("Publicado cambio de horario para clase: " + gymClass.getName());
    }
}
