package core.main;

import core.schedule.ScheduleCreatorInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  1) Добавить еще упражения по инвентарю который есть. То есть если какого-то инструмента нет - его не писать
 *  2) Добавить вариации тренировок (еффективеная, для начинающих, в зависимости от цели(соревнования...
 *  3) Добавить привязку к конкретному человеку (личное расписание с повышением весов если все отлично, с понижением весов и интенсивности,0 если долго не занимался...
 *  4) Интерфейс удобный создать!!! под десктоп, андроид, в перспективе браузер
 *
 *  5) Возможно когда-то добавить план питания, калькулятор каллорий в само приложение
 *
 *  6) В целом создать личного электронного тренера :))) =)))
 *
 *
 * Планы на сейчас:
 * 1) добавить поддержку БД с упражениями (Если подключение отсутствует или какая-то ошибка - то использовать JSON!!!
 * 2) доделать ту версию ScheduleCreatorSimple, то есть все методы прописать.
 * 3) Дэббаг и рефакторинг
 * 4) Создание первой версии пользовательского интерфейса
 *
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaConfig.class);
        ctx.refresh();

        ScheduleCreatorInterface scheduleCreator = (ScheduleCreatorInterface) ctx.getBean("ScheduleCreator");
        System.out.println(scheduleCreator.createScheduleNumberOfExercises(2));

    }

}
