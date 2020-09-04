package core.main;

import UI.MainPage;
import core.gettingAllExercises.Configurator;
import core.gettingAllExercises.ConfiguratorJSONUsingJackson;
import core.schedule.ScheduleCreatorInterface;
import core.schedule.ScheduleCreatorSimple;
import core.schedule.WorkoutSchedule;
import core.schedule.WorkoutScheduleInterface;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class JavaConfig {

    @Bean
    public MainPage getRestController() {return new MainPage();}

    @Bean("Configurator")
    public Configurator getConfigurator() {
        return new ConfiguratorJSONUsingJackson();
    }

    @Bean("ScheduleCreator")
    public ScheduleCreatorInterface getScheduleCreator() {
        return new ScheduleCreatorSimple();
    }

    @Bean("WorkoutSchedule")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WorkoutScheduleInterface getWorkoutSchedule() {
        return new WorkoutSchedule();
    }

}
