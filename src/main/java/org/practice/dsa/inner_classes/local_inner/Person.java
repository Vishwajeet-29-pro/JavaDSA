package org.practice.dsa.inner_classes.local_inner;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void printPersonDetail() {
        // Local Inner class
        class DetailPrinter {
           public void printDetails() {
               // Accessing the outer class elements
               System.out.println("Person Name: "+name);
               System.out.println("Person Age: "+age);
           }
        }
        DetailPrinter printer = new DetailPrinter();
        printer.printDetails();
    }

    public static void main(String[] args) {
        Person person = new Person("Vishwajeet",24);
        person.printPersonDetail();
    }
}
