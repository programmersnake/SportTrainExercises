package core.schedule;

import core.gettingAllExercises.Exercise;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class WorkoutSchedule implements WorkoutScheduleInterface{

    @Getter
    private List<Exercise> exerciseList = new ArrayList<>();

    final String RELAX_DESCRIPTION = "Use an ice pack.\n" +
            "Go for a massage.\n" +
            "Stretch, stretch, stretch.\n" +
            "Do light exercises (such as walking, swimming)\n" +
            "Build up eccentric exercises slowly.\n" +
            "Take a warm bath.";
    private static final String LINE_SEPARATOR = System.lineSeparator();

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
    public boolean containsExercise(Exercise exercise) {
        return exerciseList.contains(exercise);
    }

    @Override
    public boolean isEmpty() {
        return exerciseList.isEmpty();
    }

    @Override
    public String toString() {
        String toString=LINE_SEPARATOR+"WorkoutSchedule"+LINE_SEPARATOR;
        int indexOfExercisesList = 1;

        for (Exercise exercise : exerciseList) {
            toString += (String.valueOf(indexOfExercisesList) + ")" + LINE_SEPARATOR) +
                        "Name: " + exercise.getName() + LINE_SEPARATOR +
                        "Part of body: " + exercise.getPartOfBody() + LINE_SEPARATOR +
                        "Description: " + exercise.getDescription() + LINE_SEPARATOR +
                        "Number of times: " + exercise.getNumberOfTimes() + LINE_SEPARATOR +
                        "Number of tries: " + exercise.getNumberOfTries() + LINE_SEPARATOR;

            indexOfExercisesList++;
        }

        return toString;
    }

    @Override
    public Exercise RelaxAfterWorkout() {
        return new Exercise("Relax", "fullBody", RELAX_DESCRIPTION, 1, 0);
    }
}

