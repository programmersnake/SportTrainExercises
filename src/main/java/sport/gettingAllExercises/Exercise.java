package sport.gettingAllExercises;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Exercise  {

    Exercise(){}

    String name;
    String partOfBody;
    String description;
    int numberOfTimes;
    int numberOfTries;

}
