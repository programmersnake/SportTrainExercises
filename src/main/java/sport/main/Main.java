package sport.main;

import lombok.SneakyThrows;
import sport.gettingAllExercises.Configurator;
import sport.gettingAllExercises.ConfiguratorJSONUsingJackson;

//@SpringBootApplication
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        //SpringApplication.run(Main.class);

        Configurator configurator = new ConfiguratorJSONUsingJackson();

        System.out.println(configurator.convertExercisesToMap(configurator.getterListExercises()));

    }

}
