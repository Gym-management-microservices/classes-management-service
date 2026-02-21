package micro.gym.classesmanagementservice.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import micro.gym.classesmanagementservice.model.Class;
import micro.gym.classesmanagementservice.repository.ClassRepository;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Class programClass(Class gymClass) {
        return classRepository.save(gymClass);
    }

}
