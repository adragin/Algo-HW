package de.telran.lesson_9_20240829;

//  + pushToTail(int data),
//  - pushToIndex(int index, int data)
//  - removeLast(),
//  - remove(int index)
//  - get(int index)

public class MyDoubleLinkedList {
    private Node2 head;
    private Node2 tail;

    private Node2 getHead() {
        return head;
    }

    private Node2 getTail() {
        return tail;
    }

    // Вставки
    public void pushToHead(int data) {
        Node2 newNode2 = new Node2(data, null, null);

        if (head == null) {
            head = newNode2;
            tail = newNode2;
            return;
        }

        newNode2.setNext(head);
        head.setPrev(newNode2);
        head = newNode2;
    }

    public void pushToTail(int data) {
        Node2 newNode2 = new Node2(data, null, null);

        if (tail == null) {
            head = newNode2;
            tail = newNode2;
            return;
        }

        newNode2.setPrev(tail);
        tail.setNext(newNode2);
        tail = newNode2;
    }

    public void pushToIndex(int index, int data) {
        Node2 newNode2 = new Node2(data, null, null);
        Node2 current = head;
        int jump;

        if (index < 1) {
            pushToHead(data);
        } else {
            jump = 0;
            while (jump < index - 1) {
                current = current.getNext();
                jump++;
            }

            newNode2.setNext(current.getNext());
            current.getNext().setPrev(newNode2);

            newNode2.setPrev(current);
            current.setNext(newNode2);
        }

    }

    // Удаление
    public void removeFirst() {
        if (head == null) return;

        Node2 first = head;
        Node2 second = head.getNext();
        if (second != null) {       // если второй элемент существует
            second.setPrev(null);   // -> то у него надо обнулить ссылку на HEAD
        }
        head = second;              // второй элемент становится HEAD
        first.setNext(null);        // очищаем ссылку NEXT у старого HEAD (зачистка ссылок для освобождения памяти)
        first = null;               // удаляем ссылку FIRST на старый HEAD (зачистка ссылок для освобождения памяти)
    }

    public void removeLast() {
        if (head == null) return;

        Node2 last = tail;
        Node2 preLast = tail.getPrev();
        if (preLast == null) {      // если в массиве один элемент
            head = null;
            tail = null;            // зачистка
            last = null;
            return;
        }

        preLast.setNext(null);     // у предпоследнего надо обнулить ссылку NEXT на TAIL
        tail = preLast;            // второй элемент с конца становится TAIL
        last.setPrev(null);        // очищаем ссылку PREV у старого TAIL (зачистка ссылок для освобождения памяти)
        last = null;               // удаляем ссылку LAST на старый TAIL (зачистка ссылок для освобождения памяти)
    }

    public void remove(int index) {
        Node2 current = head;
        int jump;
        if (index < 1) {
            removeFirst();
        } else {
            jump = 0;
            while (jump < index - 1) {
                current = current.getNext();
                jump++;
            }

            Node2 toRemove = current.getNext();

            current.setNext(toRemove.getNext());    // проброс ссылок...
            toRemove.getNext().setPrev(current);    // ...вокруг удаляемого элемента

            toRemove.setNext(null); // зачистка ссылок с удалённой Node
            toRemove.setPrev(null); // (для освобождения памяти)
            toRemove = null;        // и ссылки на саму удалённую Node
        }
    }

    // Получить элемент
    public int get(int index) {
        int jump = -1;
        if (head == null) {
            return -1;
        }
        if (index < 0 || index > size()) {
            return -1;
        }

        Node2 node = head;
        while (node != null) {
            jump++;
            if (jump == index) {
                return node.getData();
            }
            node = node.getNext();
        }
        return -1;
    }

    // размер списка
    public int size() {
        int count = 0;
        Node2 node = head;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    public void print() {
        Node2 node = head;
        System.out.print("[");
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println("]  (HEAD = " + getHead().getData() + ", TAIL = " + getTail().getData() + ")");
    }
}

//*pushToHead(int data),
//*pushToTail(int data),
//*pushToIndex(int index, int data)
//*removeFirst(),
//*removeLast(),
//remove(int index)
//get(int index)
//*size()
//*print()

