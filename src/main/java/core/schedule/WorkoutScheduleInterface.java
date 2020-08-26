package core.schedule;

import core.gettingAllExercises.Exercise;

public interface WorkoutScheduleInterface {
    void addExercise(Exercise newExercise);
    void completeExercise(int indexOfExercise);

    int getNumberOfExercisesInSchedule();

    Exercise aboutRelaxAfterWorkout();

    boolean containsExercise(Exercise exercise);
    boolean isEmpty();
}

