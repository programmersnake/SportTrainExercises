package core.schedule;

public interface ScheduleCreatorInterface {

    WorkoutSchedule createScheduleNumberOfExercises(int numberOfExercises);
    WorkoutSchedule createScheduleTimeOfWorkout(short timeOfWorkout);
    WorkoutSchedule createScheduleOnPartOfBody(String partOfBody);

}
