package micro.gym.classesmanagementservice.exception;

import micro.gym.classesmanagementservice.model.TrainerId;

public class TrainerDoesnotExist extends RuntimeException {

    public TrainerDoesnotExist(TrainerId entrenadorId) {
        super("The trainer with id " + entrenadorId.getTrainerId_value()+ " is not registered");
    }
}
