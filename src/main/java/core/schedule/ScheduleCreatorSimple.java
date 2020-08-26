package core.schedule;

import core.gettingAllExercises.Configurator;
import core.gettingAllExercises.Exercise;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScheduleCreatorSimple implements ScheduleCreatorInterface {

    @Autowired
    private Configurator configurator;

    @Autowired
    private WorkoutScheduleInterface workoutSchedule;

    @Override
    public WorkoutScheduleInterface createScheduleNumberOfExercises(int numberOfExercises) {
        List<Exercise> exerciseList = configurator.getterListExercises();

        if(numberOfExercises>exerciseList.size())
            numberOfExercises=exerciseList.size();

        createRandomWorkoutSchedule(numberOfExercises, exerciseList);

        return workoutSchedule;
    }

    private void createRandomWorkoutSchedule(int numberOfExercises, List<Exercise> exerciseList) {
        while(workoutSchedule.getNumberOfExercisesInSchedule()!=numberOfExercises) {
            int randomIndex = (int) (Math.random()*numberOfExercises);
            Exercise newExercise = exerciseList.get(randomIndex);

            if(!workoutSchedule.containsExercise(newExercise))
                workoutSchedule.addExercise(newExercise);
        }
    }

    @Override
    public WorkoutScheduleInterface createScheduleTimeOfWorkout(short timeOfWorkout) {
        return null;
    }

    @Override
    public WorkoutScheduleInterface createScheduleOnPartOfBody(String partOfBody) {
        return null;
    }
}
