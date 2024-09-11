package de.telran.lesson_8_20240822;

public class SpecialStack {
//    empty  — проверка стека на наличие в нем элементов,
//    push  — операция вставки нового элемента,
//    pop  — операция удаления нового элемента.
//    peek - операция просмотра последнего вставленного элемента
//           (операция просмотра вершины стека)

//    Реализовать структуру данных SpecialStack, которая поддерживает все операции со стеком,
//    такие как push(), pop(), isEmpty(), … и дополнительную операцию getMin(),
//    которая должна возвращать минимальный элемент из SpecialStack.

    private final int[] arr;
    private int top;                //индекс последнего пришедшего элемента
    private final int capacity;     //общий размер структуры хранения
    private int minimal = Integer.MAX_VALUE;      //минимальный элемент

    public SpecialStack(int size) {
        this.capacity = size;
        arr = new int[this.capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1; // O(1)
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int getSize() {
        return top + 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void push(int x) {
        if (isFull())
            System.out.println("Stack overflow");
        else {
            if (x < minimal) {  // если входящий элемент меньше нашего минимального
                minimal = x;    // -> значение x станет минимальным
            }
            arr[++top] = x;
            System.out.println("Insert - " + x);
        }

//      В Java можно и так
//        try {
//            arr[++top] = x;
//            System.out.println("Insert - " + x);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Stack overflow");
//        }
    }

    // метод, который возвращает минимальный элемент  --> O(1)
    public int getMin(){
        return minimal;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }


}
