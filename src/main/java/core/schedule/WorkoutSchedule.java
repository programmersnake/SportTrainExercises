package core.schedule;

import core.gettingAllExercises.Exercise;

import java.util.ArrayList;
import java.util.List;

public class WorkoutSchedule implements WorkoutScheduleInterface{

    private List<Exercise> exerciseList = null;

    private final String RELAX_DESCRIPTION = "Use an ice pack.\n" +
            "Go for a massage.\n" +
            "Stretch, stretch, stretch.\n" +
            "Do light exercises (such as walking, swimming)\n" +
            "Build up eccentric exercises slowly.\n" +
            "Take a warm bath.";

    WorkoutSchedule() {
        exerciseList = new ArrayList<>();
    }

    private void addRelax(){
        exerciseList.add(new Exercise("Relax", "fullBody", RELAX_DESCRIPTION, 1, 0));
    }

    @Override
    public void addExercise(Exercise newExercise) {
        exerciseList.add(newExercise);
        addRelax();
    }

    @Override
    public void completeExercise(int indexOfExercise) {
        exerciseList.remove(indexOfExercise);
        exerciseList.remove(indexOfExercise+1);
    }

    @Override
    public boolean isEmpty() {
        return exerciseList.isEmpty();
    }
}

