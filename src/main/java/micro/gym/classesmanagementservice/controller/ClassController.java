package micro.gym.classesmanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import micro.gym.classesmanagementservice.model.Class;
import micro.gym.classesmanagementservice.service.ClassService;

@RestController
@RequestMapping("/classes")
public class ClassController {
 
    @Autowired
    private ClassService classService;

    @GetMapping("/all")
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @PostMapping("/program")
    public void programarClase(@RequestBody Class gymClass) {
        classService.programClass(gymClass.getTrainerId(),gymClass);
    }
}


