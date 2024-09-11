package de.telran.lesson_8_20240822;

public class SpecialStackTest {
    public static void main(String[] args) {
        SpecialStack sstack = new SpecialStack(5);
        sstack.push(5);
        sstack.push(4);
        sstack.push(3);
        sstack.push(1);
        sstack.push(2);
        sstack.push(6); // не вставиться
        sstack.printStack();

        System.out.println("min elem = " + sstack.getMin());
        System.out.println();

        System.out.println("take out - "+sstack.pop());
        sstack.printStack();

        System.out.println("take out - "+sstack.pop());
        sstack.printStack();

        System.out.println("Size = "+sstack.getSize());

        System.out.println("Top - "+sstack.peek());
        sstack.printStack();
    }
}
