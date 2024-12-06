package org.practice.dsa.stack;

import java.util.Stack;

public class CustomStack {
    private int[] stack;
    private int capacity;
    private int top;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty---");
        } else {
            for (int i = top; i >=0 ; i--) {
                System.out.print(stack[i]+ " ");
            }
            System.out.println();
        }
    }

    private boolean isFull() {
        return top == capacity -1;
    }

    private boolean isEmpty() {
        return top == -1;
    }


    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(10);
        customStack.push(10);
        customStack.push(30);
        customStack.push(50);
        customStack.push(60);
        customStack.display();

        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        customStack.display();
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        customStack.display();
        System.out.println(customStack.pop());
    }
}
