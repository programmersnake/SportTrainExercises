package core.schedule;

public interface ScheduleCreatorInterface {

    WorkoutScheduleInterface createScheduleNumberOfExercises(int numberOfExercises);
    WorkoutScheduleInterface createScheduleTimeOfWorkout(double HoursForWorkout);
    WorkoutScheduleInterface createScheduleOnPartOfBody(String partOfBody);

}
