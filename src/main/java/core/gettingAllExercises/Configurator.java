package core.gettingAllExercises;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Configurator {

    List<Exercise> getterListExercises();

    String setterListObj(List<Exercise> listObjects);

    default Map convertExercisesToMap(List<Exercise> listExercises) {
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
