package de.telran.lesson_9_20240829;

public class MainDoubleList {
    public static void main(String[] args) {
        //LinkedList<Integer> list = new LinkedList<>();

        MyDoubleLinkedList list = new MyDoubleLinkedList();

        // вставка в начало
        list.pushToHead(10);
        list.print();

        list.removeLast();
        list.pushToHead(15);
        list.print();

        list.pushToHead(12);
        list.pushToHead(33);
        list.print();
        System.out.println("Size = "+list.size());

        // удаления с начала
        list.removeFirst();
        list.print();
        System.out.println("Size = "+list.size());

        //вставка в конец
        list.pushToTail(18);
        list.pushToTail(11);
        list.print();

        //удаление с конца
        list.removeLast();
        list.print();

        // вставка по индексу
        list.pushToIndex(1, 55);
        list.print();

        list.pushToIndex(0, 66);
        list.print();

        list.pushToIndex(4, 55);
        list.print();

        //удаление ао индексу
        list.remove(1);
        list.print();

        // возврат значения по индексу
        System.out.println(list.get(2));

    }
}
