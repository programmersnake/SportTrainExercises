package core.schedule;

import core.gettingAllExercises.Exercise;

public interface WorkoutScheduleInterface {

    Exercise RelaxAfterWorkout();

    void addExercise(Exercise newExercise);
    void completeExercise(int indexOfExercise);

    int getNumberOfExercisesInSchedule();

    boolean containsExercise(Exercise exercise);
    boolean isEmpty();
}

