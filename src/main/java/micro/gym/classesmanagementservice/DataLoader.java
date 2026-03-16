package micro.gym.classesmanagementservice;

import micro.gym.classesmanagementservice.dto.CurrentOcuppationDTO;
import micro.gym.classesmanagementservice.model.*;
import micro.gym.classesmanagementservice.model.Class;
import micro.gym.classesmanagementservice.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClassRepository claseRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear algunos préstamos de ejemplo
        Class clase1 = new Class();
        clase1.setId(new ClassId("1"));
        clase1.setName("Yoga Matutino");
        clase1.setScheduleStart(new ScheduleStart(LocalDate.now().plusDays(1)));
        clase1.setScheduleEnd(new ScheduleEnd(LocalDate.now().plusDays(1)));
        clase1.setTrainerId(new TrainerId("T1"));
        clase1.setMaxCapacity(new MaxCapacity(20));
        clase1.setCurrentOccupation(new CurrentOcuppationDTO("1","T1", 0));
        claseRepository.save(clase1);

        Class clase2 = new Class();
        clase2.setId(new ClassId("2"));
        clase2.setName("Spinning");
        clase2.setScheduleStart(new ScheduleStart(LocalDate.now().plusDays(1)));
        clase2.setScheduleEnd(new ScheduleEnd(LocalDate.now().plusDays(1)));
        clase2.setTrainerId(new TrainerId("T2"));
        clase2.setMaxCapacity(new MaxCapacity(10));
        clase1.setCurrentOccupation(new CurrentOcuppationDTO("2","T2", 0));
        claseRepository.save(clase2);

        System.out.println("Datos de clase de ejemplo cargados exitosamente.");
    }
}