package core.main;

import core.gettingAllExercises.Configurator;
import core.gettingAllExercises.ConfiguratorJSONUsingJackson;
import core.schedule.ScheduleCreatorInterface;
import core.schedule.ScheduleCreatorSimple;
import core.schedule.WorkoutSchedule;
import core.schedule.WorkoutScheduleInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {

    @Bean("Configurator")
    public Configurator getConfigurator() {
        return new ConfiguratorJSONUsingJackson();
    }

    @Bean("ScheduleCreator")
    public ScheduleCreatorInterface getScheduleCreator() {
        return new ScheduleCreatorSimple();
    }

    @Bean("WorkoutSchedule")
    @Scope(scopeName = "prototype")
    public WorkoutScheduleInterface getWorkoutSchedule() {
        return new WorkoutSchedule();
    }

}
