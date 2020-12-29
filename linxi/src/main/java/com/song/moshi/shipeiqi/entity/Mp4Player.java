package com.song.moshi.shipeiqi.entity;

import com.song.moshi.shipeiqi.AdvancedMediaPlayer;

/**
 * @Auther: sf
 * @Date: 2020/8/20
 * @version: 1.0
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }


}
