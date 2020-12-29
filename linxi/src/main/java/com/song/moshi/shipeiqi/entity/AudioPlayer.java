package com.song.moshi.shipeiqi.entity;

import com.song.moshi.shipeiqi.MediaPlayer;

/**
 * @Auther: sf
 * @Date: 2020/8/20
 * @version: 1.0
 */
public class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {

        if(audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,  fileName);
        }
    }


    public static void main(String[] args) {
        AudioPlayer audioPlayer  = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }

}
