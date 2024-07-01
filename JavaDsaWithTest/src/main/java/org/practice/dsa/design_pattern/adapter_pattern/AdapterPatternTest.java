package org.practice.dsa.design_pattern.adapter_pattern;

public class AdapterPatternTest {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","Om Sai Ram by suresh wadkar");
        audioPlayer.play("mp4","Om Sai by Anuradha");
        audioPlayer.play("vlc","Sai baba Aarti");
        audioPlayer.play("avi","audio 200");
    }
}
