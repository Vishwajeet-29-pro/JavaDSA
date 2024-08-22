package org.practice.dsa.solidprinciple.isp;

public class HumanWorker implements Workable, Eatable {

    @Override
    public void eat() {
        System.out.println("Human Eating...");
    }

    @Override
    public void work() {
        System.out.println("Human Working...");
    }
}
