package org.practice.dsa.solidprinciple.isp;

interface Worker {
    void work();
    void eat();
}

class OldHumanWorker implements Worker {

    @Override
    public void work() {
        System.out.println("Human Working...");
    }

    @Override
    public void eat() {
        System.out.println("Human Eating...");
    }
}

class OldRobotWorker implements Worker {

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
        OldHumanWorker hw = new OldHumanWorker();
        hw.work();
        hw.eat();

        OldRobotWorker rw = new OldRobotWorker();
        rw.work();
        rw.eat();
    }
}
