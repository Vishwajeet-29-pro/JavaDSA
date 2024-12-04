package org.practice.dsa.leet_code.easy.linkedlist;

public class ConvertBinary {
    public static void main(String[] args) {
        ConvertBinary binary = new ConvertBinary();
        binary.insertFirst(1);
        binary.insertFirst(0);
        binary.insertFirst(1);
        binary.display();

        System.out.println(binary.getDecimalValue());
        System.out.println(binary.binaryToDecimal(101));

    }

//    https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
    public int getDecimalValue() {
        ListNode node = head;
        int result = 0;
        while (node != null) {
            result = result * 10 + node.val;
            node = node.next;
        }

        return binaryToDecimal(result);
    }

    private int binaryToDecimal(int binaryNumber) {
        int power = 0;
        int result = 0;
        while (binaryNumber > 0) {
            int lastDigit = binaryNumber % 10;
            result += (int) (lastDigit * Math.pow(2, power));
            binaryNumber = binaryNumber/10;
            power++;
        }
        return result;

    }

    private int power(int input) {
        int count = 0;
        while (input > 0) {
            input = input /10;
            count++;
        }
        return count;
    }


    ListNode head;
    ListNode tail;
    int size;

    public ConvertBinary() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size +=1;
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
