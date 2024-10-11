import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevatorSystem {  // Реализация для лифтов больше двух

    public static void main(String[] args) {
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(new Elevator("Лифт A", 0));  // Лифт A на 0 этаже
        elevators.add(new Elevator("Лифт B", 8));  // Лифт B на 8 этаже
        elevators.add(new Elevator("Лифт C", 15)); // Лифт С на 15 этаже

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите этаж вызова : ");
        int requestedFloor = scanner.nextInt();

        getClosestElevator(elevators, requestedFloor);
    }

    public static void getClosestElevator(List<Elevator> elevators, int requestedFloor) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - requestedFloor);
            if (distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }

        if (closestElevator != null) {
            System.out.println("Отправляем лифт " + closestElevator.getElevatorTitle());
            closestElevator.moveToFloor(requestedFloor);
        }
    }


}
