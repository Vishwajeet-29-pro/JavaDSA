package org.practice.dsa.design_pattern.observer_pattern;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();
}
