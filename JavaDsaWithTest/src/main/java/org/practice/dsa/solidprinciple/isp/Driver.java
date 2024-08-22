package org.practice.dsa.solidprinciple.isp;

public class Driver {
    public static void main(String[] args) {
        HumanWorker worker = new HumanWorker();
        worker.work();
        worker.eat();

        RobotWorker robotWorker = new RobotWorker();
        robotWorker.work();
    }
}
