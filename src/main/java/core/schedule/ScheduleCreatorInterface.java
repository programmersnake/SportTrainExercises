package core.schedule;

public interface ScheduleCreatorInterface {

    WorkoutScheduleInterface createScheduleNumberOfExercises(int numberOfExercises);
    WorkoutScheduleInterface createScheduleTimeOfWorkout(short timeOfWorkout);
    WorkoutScheduleInterface createScheduleOnPartOfBody(String partOfBody);

}
