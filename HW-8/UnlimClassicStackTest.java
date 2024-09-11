package de.telran.lesson_8_20240822;

public class UnlimClassicStackTest {
    public static void main(String[] args) {
        UnlimClassicStack stack = new UnlimClassicStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Size = "+stack.getSize());
        stack.push(6); // вставится c увеличением ёмкости массива
        System.out.println("Size = "+stack.getSize());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printStack();
        System.out.println("Size = "+stack.getSize());

        System.out.println("take out - "+stack.pop());
        stack.printStack();

        System.out.println("take out - "+stack.pop());
        stack.printStack();

        System.out.println("Size = "+stack.getSize());

        System.out.println("Top - "+stack.peek());
        stack.printStack();
    }
}
