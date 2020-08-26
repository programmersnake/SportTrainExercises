package core.schedule;

import core.gettingAllExercises.Exercise;

import java.util.ArrayList;
import java.util.List;

public class WorkoutSchedule implements WorkoutScheduleInterface{

    private List<Exercise> exerciseList = new ArrayList<>();

    private final String RELAX_DESCRIPTION = "Use an ice pack.\n" +
            "Go for a massage.\n" +
            "Stretch, stretch, stretch.\n" +
            "Do light exercises (such as walking, swimming)\n" +
            "Build up eccentric exercises slowly.\n" +
            "Take a warm bath.";

    @Override
    public void addExercise(Exercise newExercise) {
        exerciseList.add(newExercise);
    }

    @Override
    public void completeExercise(int indexOfExercise) {
        exerciseList.remove(indexOfExercise);
        exerciseList.remove(indexOfExercise+1);
    }

    @Override
    public int getNumberOfExercisesInSchedule() {
        return exerciseList.size();
    }

    @Override
    public Exercise aboutRelaxAfterWorkout() {
        return new Exercise("Relax", "fullBody", RELAX_DESCRIPTION, 1, 0);
    }

    @Override
    public boolean containsExercise(Exercise exercise) {
        return exerciseList.contains(exercise);
    }

    @Override
    public boolean isEmpty() {
        return exerciseList.isEmpty();
    }

    @Override
    public String toString() {
        return exerciseList.toString();
    }
}

