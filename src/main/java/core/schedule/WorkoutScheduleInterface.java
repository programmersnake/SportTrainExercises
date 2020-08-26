package core.schedule;

import core.gettingAllExercises.Exercise;

interface WorkoutScheduleInterface {
    void addExercise(Exercise newExercise);
    void completeExercise(int indexOfExercise);

    boolean isEmpty();
}

