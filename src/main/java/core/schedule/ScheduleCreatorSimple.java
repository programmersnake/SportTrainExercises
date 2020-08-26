package core.schedule;

import core.gettingAllExercises.Configurator;
import core.gettingAllExercises.Exercise;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

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
            int randomIndex = (int) (Math.random()*exerciseList.size());
            Exercise newExercise = exerciseList.get(randomIndex);

            if(!workoutSchedule.containsExercise(newExercise))
                workoutSchedule.addExercise(newExercise);
        }
        workoutSchedule.addExercise(workoutSchedule.RelaxAfterWorkout());
    }

    @Override
    public WorkoutScheduleInterface createScheduleTimeOfWorkout(double HoursForWorkout) {
        int numberExercises = (int) (HoursForWorkout * 10);
        return createScheduleNumberOfExercises(numberExercises);
    }

    @Override
    public WorkoutScheduleInterface createScheduleOnPartOfBody(String partOfBody) {
        Map<String, List<Exercise>> exerciseMap = configurator.convertExercisesToMap(configurator.getterListExercises());

        try{
            List<Exercise> exerciseList = exerciseMap.get(partOfBody);

            for (Exercise exercise : exerciseList)
                workoutSchedule.addExercise(exercise);
            return workoutSchedule;
        }
        catch(Exception ex) {
            return null;
        }

    }
}
