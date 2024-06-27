package com.practice.dsa.design_pattern;

import com.practice.dsa.design_pattern.proxy_pattern.Image;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading... "+fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying... "+fileName);
    }
}
