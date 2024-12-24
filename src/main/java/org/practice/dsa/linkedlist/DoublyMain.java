package org.practice.dsa.linkedlist;

public class DoublyMain {
    public static void main(String[] args) {
        DoublyLinkedList dd = new DoublyLinkedList();
        dd.insertFirst(10);
        dd.insertFirst(9);
        dd.insertFirst(8);
        dd.insertFirst(7);
        dd.insertLast(11);

//        dd.insert(10, 8);
//        dd.display();

//        System.out.println(dd.deleteFirst());
//        dd.display();

//        System.out.println(dd.deleteLast());
//        dd.display();

        dd.display();
        System.out.println(dd.delete(3));
        dd.display();
    }
}
