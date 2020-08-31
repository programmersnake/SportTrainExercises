package core.gettingAllExercises;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Configurator {

    List<Exercise> getListExercises();

    void addNewExercise(Exercise newExercise);

    default Map<String, List<Exercise>> convertExercisesToMap(List<Exercise> listExercises) {
        Map<String, List<Exercise>> mapExercises = new HashMap<>();

        for (Exercise exercise:listExercises) {
            if(!mapExercises.containsKey(exercise.getPartOfBody())) {
                List<Exercise> list = new ArrayList<>();
                list.add(exercise);
                mapExercises.put(exercise.getPartOfBody(), list);
            }
            else {
                mapExercises.get(exercise.getPartOfBody()).add(exercise);
            }
        }

        return mapExercises;
    }

}
