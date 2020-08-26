package core.schedule;

import core.gettingAllExercises.Configurator;
import org.springframework.beans.factory.annotation.Autowired;


public class ScheduleCreatorSimple implements ScheduleCreatorInterface {

    @Autowired
    private Configurator configurator;

    @Override
    public WorkoutSchedule createScheduleNumberOfExercises(int numberOfExercises) {
        System.out.println(configurator.convertExercisesToMap(configurator.getterListExercises()));
        return null;
    }

    @Override
    public WorkoutSchedule createScheduleTimeOfWorkout(short timeOfWorkout) {
        return null;
    }

    @Override
    public WorkoutSchedule createScheduleOnPartOfBody(String partOfBody) {
        return null;
    }
}
