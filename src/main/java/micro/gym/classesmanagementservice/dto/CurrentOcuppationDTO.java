package micro.gym.classesmanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentOcuppationDTO {
    private String classId;
    private String trainerId;
    private int currentOccupation;
}
