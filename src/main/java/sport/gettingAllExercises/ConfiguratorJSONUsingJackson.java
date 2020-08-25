package sport.gettingAllExercises;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ConfiguratorJSONUsingJackson implements Configurator {

    private ObjectMapper objectMapper = new ObjectMapper();
    private String fullPath = null;

    public ConfiguratorJSONUsingJackson() {
        this.fullPath = "C:\\Users\\kosti\\IdeaProjects\\SportTrainExercises\\src\\main\\resources\\exercises.cnfg";
    }

    public ConfiguratorJSONUsingJackson(String fullPath) {
        this.fullPath = fullPath;
    }

    @SneakyThrows
    private String getTextJsonFile() {
        String exercisesTextJson="[";

        FileReader reader = new FileReader(fullPath);

        BufferedReader bufferedReader = new BufferedReader(reader);
        while(bufferedReader.read()!=-1) {
            exercisesTextJson+=bufferedReader.readLine();
        }
        return exercisesTextJson;
    }


    @SneakyThrows
    @Override
    public List<Exercise> getterListExercises(){
        String exercisesTextJson = getTextJsonFile();

        Exercise[] listExercises = objectMapper.readValue(exercisesTextJson, Exercise[].class);

        return List.of(listExercises);
    }

    @SneakyThrows
    @Override
    public String setterListObj(List<Exercise> listObjects) {
        String jsonStr = objectMapper.writeValueAsString(listObjects);

        return jsonStr;
    }
}
