package com.song.moshi.shipeiqi.entity;

import com.song.moshi.shipeiqi.AdvancedMediaPlayer;
import com.song.moshi.shipeiqi.MediaPlayer;

/**
 * @Auther: sf
 * @Date: 2020/8/20
 * @version: 1.0
 */
// 这个类的作用主要是给真正的接口确定是哪一个实现类
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;
    public MediaAdapter(String audioType){

        if(audioType.equals("mp4")){

            advancedMediaPlayer = new Mp4Player();
        }else{

            advancedMediaPlayer = new VlcPlayer();
        }
        System.out.println("这个这么会自动走构造方法"+audioType);


    }


    @Override
    public void play(String audioType, String fileName) {

       if(audioType.equalsIgnoreCase("mp4")){
           advancedMediaPlayer.playMp4(fileName);
       }else{
           advancedMediaPlayer.playVlc(fileName);
       }


    }
}
