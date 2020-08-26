package core.main;

import core.schedule.ScheduleCreatorInterface;
import core.schedule.ScheduleCreatorSimple;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import core.gettingAllExercises.Configurator;
import core.gettingAllExercises.ConfiguratorJSONUsingJackson;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaConfig.class);
        ctx.refresh();

        ScheduleCreatorInterface scheduleCreator = ctx.getBean(ScheduleCreatorInterface.class);
        scheduleCreator.createScheduleNumberOfExercises(12);

    }

}
