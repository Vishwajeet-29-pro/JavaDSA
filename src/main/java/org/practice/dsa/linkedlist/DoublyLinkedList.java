package org.practice.dsa.linkedlist;

public class DoublyLinkedList {

    Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        node.next = null;
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public void insert(int val, int after) {
        Node p = find(after);
        if (p == null) {
            System.out.println("does not exists");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int deleteFirst() {
        if (head == null) {
            throw new RuntimeException("List is Empty");
        }
        int val = head.val;
        head = head.next;

        if (head != null) {
            head.prev = null;
        }
        return val;
    }

    public int deleteLast() {
        if (head == null) {
            throw new RuntimeException("List is Empty");
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        int val = last.val;

        if (last.prev != null) {
            last.prev.next = null;
        } else {
            head = null;
        }
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            deleteFirst();
        }

        Node node = get(index);

        int val = node.val;

        if (node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            node.prev.next = null;
        }
        return val;
    }

    public Node get(int index) {
        Node temp = head;
        int i = 0;

        while (temp != null && i < index) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public void display() {
        Node node = head;
        Node last = null;

        while (node != null) {
            System.out.print(node.val + "->");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        while (last != null) {
            System.out.print(last.val + "->");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
