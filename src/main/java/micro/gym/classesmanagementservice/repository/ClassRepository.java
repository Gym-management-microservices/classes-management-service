package micro.gym.classesmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import micro.gym.classesmanagementservice.model.Class;
import micro.gym.classesmanagementservice.model.ClassId;

public interface ClassRepository extends JpaRepository<Class, ClassId> {

}
