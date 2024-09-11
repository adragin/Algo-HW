package de.telran.lesson_8_20240822;

public class SpecialQueue {
//    empty — проверка очереди на наличие в ней элементов,
//    push — операция вставки нового элемента,
//    pop — операция удаления нового элемента,
//    size — операция получения количества элементов в очереди.
//    peek - операция просмотра элемента, который можно извлечь

//    Реализовать структуру данных SpecialQueue, которая поддерживает все операции с очередью,
//            … и дополнительную операцию getMax(),
//    которая должна возвращать максимальный элемент из SpecialQueue.
//    Чтобы реализовать SpecialQueue, используйте структуру данных Queue, реализованную ранее в классе.


    private int[] arr;
    private int head;           //индекс извлекаемого элемента
    private int tail;           //индекс для вставки нового элемента
    private int capacity;       //общий размер структуры хранения
    private int count;          //количество реальных элементов в очереди
    private int maximum = Integer.MIN_VALUE;      //максимальное значение массива

    public SpecialQueue(int size) {
        this.capacity = size;
        arr = new int[capacity];
        head = 0;
        tail = -1;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == capacity;
    }

    public void printQueue() {
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("count - " + count);
    }

    private void moveQueue() { // перемещаем элементы
        for (int i = 1; i < count; i++) {
            arr[i - 1] = arr[i];
        }
    }

    public int getSize() {
        return count;
    }

    public void push(int x) {   // вставлять будем в конец массива
        if (isFull()) {         // очередь заполнена
            System.out.println("Queue overflow");
        } else {     // вставляем элемент
            if (x > maximum) {  // если входящий элемент больше нашего максимального
                maximum = x;    //  -> значение x станет максимальным
            }
            tail++;
            arr[tail] = x;
            count++;
            System.out.println(x + " - add to the queue");
        }
    }

    // метод, который возвращает максимальный элемент  --> O(1)
    public int getMax(){
        return maximum;
    }

    public int pop() { //извлекает элемент из очереди
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = arr[head];
        moveQueue();
        count--;
        return val;
    }

    public int peek() { //просматривает элемент
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[head];
    }

}
