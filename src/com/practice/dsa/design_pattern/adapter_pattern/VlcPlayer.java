package com.practice.dsa.design_pattern.adapter_pattern;

public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        // Do Nothing
    }

    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file: "+fileName);
    }
}
