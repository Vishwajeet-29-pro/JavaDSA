package org.practice.dsa.design_pattern.adapter_pattern;

public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 file: "+fileName);
    }

    @Override
    public void playVLC(String fileName) {
        // Do Nothing
    }
}
