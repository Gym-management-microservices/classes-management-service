package micro.gym.classesmanagementservice.service;

import micro.gym.classesmanagementservice.dto.CurrentOcuppationDTO;
import micro.gym.classesmanagementservice.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerOcupationClass {

    @Autowired
    private KafkaTemplate<String, CurrentOcuppationDTO> kafkaTemplate;
    public void updateOcupation(Class clase) {
        clase.getCurrentOccupation().setCurrentOccupation(clase.getCurrentOccupation().getCurrentOccupation() + 1);
        CurrentOcuppationDTO currentOcupationDTO =
                new CurrentOcuppationDTO(clase.getId().getClassId_value(),
                clase.getTrainerId().getTrainerId_value(),
                clase.getCurrentOccupation().getCurrentOccupation());
        kafkaTemplate.send("ocupacion-clases", currentOcupationDTO);
    }

}
