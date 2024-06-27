package com.practice.dsa.design_pattern.adapter_pattern;

public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // in built support to play Mp3 music files
        if (audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing Mp3 file. Name: "+fileName);
        }
        // MediaAdapter support to play other format of files.
        else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else System.out.println("Invalid Media. "+audioType+ " format not supported");
    }
}
