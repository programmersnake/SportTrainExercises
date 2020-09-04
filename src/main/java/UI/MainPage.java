package UI;

import core.gettingAllExercises.Exercise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainPage implements ControllerInterface{

    @Override
    @GetMapping("/set_new_exercise")
    public void setNewExercise(@RequestParam(value = "name", defaultValue = "TestName") String name,
                                   @RequestParam(value = "part", defaultValue = "TestPartOfBody") String partOfBody,
                                   @RequestParam(value = "description", defaultValue = "TestPartOfBody") String description,
                                   @RequestParam(value = "times", defaultValue = "TestTimes") int numberOfTimes,
                                   @RequestParam(value = "tries", defaultValue = "TestTries") int numberOfTries) {
        //pass
    }

    @Override
    @GetMapping("/get_schedule")
    public Exercise getSchedule() {
        return new Exercise("fgh", "ge", "description", 12, 4);
    }
}
