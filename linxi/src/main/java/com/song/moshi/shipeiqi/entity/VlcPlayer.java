package com.song.moshi.shipeiqi.entity;

import com.song.moshi.shipeiqi.AdvancedMediaPlayer;

/**
 * @Auther: sf
 * @Date: 2020/8/20
 * @version: 1.0
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }


}
