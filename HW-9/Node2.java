package de.telran.lesson_9_20240829;

public class Node2 {
    private int data;
    private Node2 next;
    private Node2 prev;

    public Node2(int data, Node2 prev, Node2 next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }

    public Node2 getPrev() {
        return prev;
    }

    public void setPrev(Node2 prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "data=" + data +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
