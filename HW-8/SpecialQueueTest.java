package de.telran.lesson_8_20240822;

public class SpecialQueueTest {
    public static void main(String[] args) {
        SpecialQueue queue = new SpecialQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6); // не вставиться
        queue.printQueue();
        System.out.println();

        System.out.println("take out - " + queue.pop());
        queue.printQueue();

        System.out.println("take out - " + queue.pop());
        queue.printQueue();

        System.out.println();
        System.out.println("head - " + queue.peek());
        queue.printQueue();

        System.out.println("head - " + queue.peek());
        queue.printQueue();
    }
}
