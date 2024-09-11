package de.telran.lesson_8_20240822;

public class UnlimClassicStack {
//    empty  — проверка стека на наличие в нем элементов,
//    push  — операция вставки нового элемента,
//    pop  — операция удаления нового элемента.
//    peek - операция просмотра последнего вставленного элемента
//           (операция просмотра вершины стека)

    private int[] arr;
    private int top;        //индекс последнего пришедшего элемента
    private int capacity;   //общий размер структуры хранения

    public UnlimClassicStack(int size) {
        this.capacity = size;
        arr = new int[this.capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1; // O(1)
    }

    public boolean isFull() {
        return top == capacity-1;
    }

    public int getSize() {
        return top+1;
    }

    public void printStack() {
        for (int i = 0; i <= top ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void push(int x) {
        if(isFull()) {
            growCapacity();
        }
        arr[++top] = x;
        System.out.println("Insert - " + x);

    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    // метод увеличения ёмкости массива в 1,5 раза
    private void growCapacity() {
        int nSize = (int) (capacity * 1.5);
        int[] temp = new int[nSize];

        System.arraycopy(arr, 0, temp, 0, capacity);
        arr = temp;
        capacity = nSize;
    }


}
