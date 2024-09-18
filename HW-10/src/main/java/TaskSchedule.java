import java.util.Arrays;
import java.util.Comparator;

//  Начало недели, у разработчика в бэк-логе есть список задач от разных отделов,
//  каждая из которых требует определённого времени для выполнения.
//  Разработчик может в неделю работать определенное количество времени maxTime.
//  Мы хотим выбрать максимальное количество задач, которые можно выполнить,
//  учитывая ограничение по времени.
//  Используйте подход жадного алгоритма по критерию: время выполнения задачи.

public class TaskSchedule {

    public static void main(String[] args) {
        Task[] tasks = {
                new Task(2),
                new Task(3),
                new Task(1),
                new Task(2),
                new Task(4),
                new Task(7),
                new Task(11),
                new Task(6),
                new Task(5)
        };

        int maxTime = 25; // максимальное время работы в неделю

        int maxTasks = getMaxTasks(tasks, maxTime);
        System.out.println("Максимальное количество задач: " + maxTasks);
    }

    public static int getMaxTasks(Task[] tasks, int maxTime) {
        Arrays.sort(tasks, Comparator.comparingInt(t -> t.time));   // Сортируем задачи по времени выполнения

        int totalTime = 0;
        int counterTasks = 0;

        for (Task task : tasks) {
            if (totalTime + task.time <= maxTime) {    // Выбираем задачи, пока есть доступное время
                totalTime += task.time;
                counterTasks++;
            } else {
                break; // Прерываем, если превышаем лимит
            }
        }

        return counterTasks;
    }
}
