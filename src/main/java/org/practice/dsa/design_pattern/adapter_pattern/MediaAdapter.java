package org.practice.dsa.design_pattern.adapter_pattern;

public class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType){
        if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer = new Mp4Player();
        } else if (audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer.playVLC(fileName);
        }
    }
}
