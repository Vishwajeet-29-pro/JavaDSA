package org.practice.dsa.linkedlist;

public class CircularMain {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insert(10);
        cll.insert(11);
        cll.insert(12);
        cll.insert(13);
        cll.insert(14);
        cll.insert(15);

        cll.display();

        cll.delete(12);
        cll.delete(13);

        cll.display();
    }
}
