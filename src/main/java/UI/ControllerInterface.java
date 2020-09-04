package UI;

import core.gettingAllExercises.Exercise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ControllerInterface {



    @GetMapping("/set_new_exercise")
    public void setNewExercise(@RequestParam(value = "name", defaultValue = "TestName") String name,
                               @RequestParam(value = "part", defaultValue = "TestPartOfBody") String partOfBody,
                               @RequestParam(value = "description", defaultValue = "TestPartOfBody") String description,
                               @RequestParam(value = "times", defaultValue = "TestTimes") int numberOfTimes,
                               @RequestParam(value = "tries", defaultValue = "TestTries") int numberOfTries);

    @GetMapping("/get_schedule")
    public Exercise getSchedule();

}
