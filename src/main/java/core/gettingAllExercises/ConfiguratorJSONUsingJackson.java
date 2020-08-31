package core.gettingAllExercises;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfiguratorJSONUsingJackson implements Configurator {

    private ObjectMapper objectMapper = new ObjectMapper();
    private String fullPath = null;
    private List<Exercise> exerciseList = null;

    public ConfiguratorJSONUsingJackson() {
        this.fullPath = "C:\\Users\\kosti\\IdeaProjects\\SportTrainExercises\\src\\main\\resources\\exercises.cnfg";
    }

    @PostConstruct
    @SneakyThrows
    private void init() {
        String exercisesTextJson = getTextFromJsonFile();
        Exercise[] arrayExercises = objectMapper.readValue(exercisesTextJson, Exercise[].class);
        exerciseList = new ArrayList(Arrays.asList(arrayExercises));
    }

    public ConfiguratorJSONUsingJackson(String fullPath) {
        this.fullPath = fullPath;
    }

    @SneakyThrows
    private String getTextFromJsonFile() {
        String exercisesTextJson="[";

        FileReader reader = new FileReader(fullPath);
        BufferedReader bufferedReader = new BufferedReader(reader);

        while(bufferedReader.read()!=-1) {
            exercisesTextJson+=bufferedReader.readLine();
        }

        bufferedReader.close();

        return exercisesTextJson;
    }

    @SneakyThrows
    @Override
    public List<Exercise> getListExercises(){
        return exerciseList;
    }

    @SneakyThrows
    @Override
    public void addNewExercise(Exercise newExercise) {
        exerciseList.add(newExercise);
        String jsonStr = objectMapper.writeValueAsString(exerciseList);
        saveTextToJsonFile(jsonStr);
    }

    @SneakyThrows
    private void saveTextToJsonFile(String jsonString) {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath, false));
        writer.write(jsonString);

        writer.close();
    }
}
