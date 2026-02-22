package micro.gym.classesmanagementservice.service;
import java.util.List;

import jakarta.transaction.Transactional;
import micro.gym.classesmanagementservice.exception.TrainerDoesnotExist;
import micro.gym.classesmanagementservice.model.TrainerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import micro.gym.classesmanagementservice.model.Class;
import micro.gym.classesmanagementservice.repository.ClassRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private RestTemplate restTemplate;

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }
    @Transactional
    public void programClass(TrainerId trainerid, Class gymClass) {
        Boolean entrenadorExiste = restTemplate.getForObject(
                "http://localhost:8100/trainer/search/" + trainerid.getTrainerId_value(), Boolean.class);
        if (Boolean.TRUE.equals(entrenadorExiste)) {
            classRepository.save(gymClass);
        } else {
            throw new TrainerDoesnotExist(trainerid);
        }
    }
}
