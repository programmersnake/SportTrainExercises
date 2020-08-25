package sport.schedule;

public interface ScheduleCreatorInterface {

    WorkoutSchedule createSchedule(int numberOfExercises);
    WorkoutSchedule createSchedule(int timeOfWorkout);

}
