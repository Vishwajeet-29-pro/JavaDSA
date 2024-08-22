package org.practice.dsa.solidprinciple.isp;

interface Worker {
    void work();
    void eat();
}

class HumanWorker implements Worker {

    @Override
    public void work() {
        System.out.println("Human Working...");
    }

    @Override
    public void eat() {
        System.out.println("Human Eating...");
    }
}

class RobotWorker implements Worker {

    @Override
    public void work() {
        System.out.println("Robot working...");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robot don't eat...");
    }
}

public class OldCode {
    public static void main(String[] args) {
        HumanWorker hw = new HumanWorker();
        hw.work();
        hw.eat();

        RobotWorker rw = new RobotWorker();
        rw.work();
        rw.eat();
    }
}
