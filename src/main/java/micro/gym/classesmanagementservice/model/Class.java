package micro.gym.classesmanagementservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Class {

    @EmbeddedId
    private ClassId id;

    @Column(name = "name")
    private String name;

    @Embedded
    private TrainerId trainerId;

    @Embedded
    private ScheduleStart scheduleStart;

    @Embedded
    private ScheduleEnd scheduleEnd;

    @Embedded
    private MaxCapacity maxCapacity;
}