package com.kitten.Model;

import com.sun.tools.javac.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 音乐类
 */
public class Music {
    private static Clip clip;
    /**
     * 当前jar包路径
     */
//    private static String LOCATION;

//    static {
//        LOCATION = URLDecoder.decode(Music.class.getProtectionDomain()
//                .getCodeSource().getLocation().getFile(), StandardCharsets.UTF_8);
//    }
    public void playMusic() {
        try{
//            File musicPath = new File(LOCATION+"\\music\\哪里都是你.wav");
            File  musicPath = new File("src/music/哪里都是你.wav");
//            InputStream musicPath = this.getClass().getResourceAsStream("\\哪里都是你.wav");

            //获取音频流
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            /**
             * 参考https://docs.oracle.com/javase/7/docs/api/javax/sound/sampled/Clip.html
             */
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            //获取音频时长
//            long round = Math.round(clip.getMicrosecondLength() / 1000000D);
            FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            //设置音量，范围为 -60.0f 到 6.0f
            gainControl.setValue(3.0f);
            clip.start();
            //音乐多长时间，就睡眠多长时间
            //Thread.sleep(round*1000);

            /**
             * 循环播放 其他 可用方法有start()和stop()
             */
            while (true){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
