package com.practice.dsa.design_pattern.observer_pattern;

public interface Subject {
    void attach();
    void detach();
    void notifyObserver();
}
