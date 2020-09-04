package core.main;

import core.gettingAllExercises.Configurator;
import core.gettingAllExercises.Exercise;
import core.schedule.ScheduleCreatorInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/*
 *  1) Добавить еще упражения по инвентарю который есть. То есть если какого-то инструмента нет - его не писать
 *  2) Добавить вариации тренировок (еффективеная, для начинающих, в зависимости от цели(соревнования...
 *  3) Добавить привязку к конкретному человеку (личное расписание с повышением весов если все отлично, с понижением весов и интенсивности,0 если долго не занимался...
 *  4) Добавить интерфейс удобный создать!!! под десктоп, андроид, в перспективе браузер
 *
 *  5) Возможно когда-то добавить план питания, калькулятор каллорий в само приложение
 *
 *  6) В целом создать личного электронного тренера :))) =)))
 *
 *
 * Планы на сейчас:
 * ДОБАВUТЬ РЕКОМЕНДАЦUU К УПРАЖЕНUЯМ
 * Добавить готовые спец. тренировки
 * 1) добавить поддержку БД с упражениями (Если подключение отсутствует или какая-то ошибка - то использовать JSON!!! Add using DataBase with exercises If connection is good. And using Json if it have exception or error
 * 2) Дэббаг и рефакторинг. Debugging & Refactoring
 * 3) Создание первой версии пользовательского интерфейса. Create UI
 *
 *
 *   Press, back, pectoral, triceps, biceps, stopa, golen, predplechie, chey, trapecia, plechi, kvadraceps, chirochaichie, yagotica
 *
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);

        /*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaConfig.class);
        ctx.refresh();

        ScheduleCreatorInterface scheduleCreator = (ScheduleCreatorInterface) ctx.getBean("ScheduleCreator");

        String partOfBodyString = "pectoral";

        System.out.println(scheduleCreator.createScheduleOnPartOfBody(partOfBodyString));
*/
    }

    static boolean addExercisesToListAndFile(Configurator configurator, String partOfBodyString){
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println();
            System.out.print("name=");
            String name = scanner.nextLine();
            System.out.println();
            System.out.print("Enter=\\n\\n.  description=");
            String description = scanner.nextLine();
            System.out.println();
            System.out.print("times=");
            int times = scanner.nextInt();
            System.out.println();
            System.out.print("tries=");
            int tries = scanner.nextInt();

            Exercise exercise = new Exercise(name, partOfBodyString, description, times, tries);
            configurator.addNewExercise(exercise);

            return true;
        } catch (Exception exception) {
            return false;
        }

    }

}
