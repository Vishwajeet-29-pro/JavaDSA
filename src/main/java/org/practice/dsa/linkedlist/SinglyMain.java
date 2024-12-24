package org.practice.dsa.linkedlist;

public class SinglyMain {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);

        list.insertLast(100);
        list.display();
        list.insert(70, 3);
        list.display();
        System.out.println(list.deleteFirst());;
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
    }
}
