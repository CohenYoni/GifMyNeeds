package com.gifmyneeds.activities.child;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.gifmyneeds.R;
import com.gifmyneeds.activities.MainActivity;
import com.gifmyneeds.models.ChildGifs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GifBoardActivity extends AppCompatActivity {



    final static int LIMIT = 6;
    private MediaPlayer mp;
    private ChildGifs child;
    private ArrayList<String> childVideoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gif_board_activity_layout);


        //Intent intent = getIntent();
        //child = (ChildGifs) intent.getSerializableExtra("childgifs");


        //childVideoList = child.getPathGif();
        childVideoList = new ArrayList<String>();
        childVideoList.add(R.raw.eat_sandwich + "");
        childVideoList.add(R.raw.eat_bamba + "");
        childVideoList.add(R.raw.drink_tea + "");
        childVideoList.add(R.raw.drink_coke + "");
        childVideoList.add(R.raw.thanks + "");


        getWindow().setFormat(PixelFormat.UNKNOWN);


        //Initialize Buttons
        final Button buttonPlayVideo1 = (Button)findViewById(R.id.buttonVideo1);
        final Button buttonPlayVideo2 = (Button)findViewById(R.id.buttonVideo2);
        final Button buttonPlayVideo3 = (Button)findViewById(R.id.buttonVideo3);
        final Button buttonPlayVideo4 = (Button)findViewById(R.id.buttonVideo4);
        final Button buttonPlayVideo5 = (Button)findViewById(R.id.buttonVideo5);
        final Button buttonPlayVideo6 = (Button)findViewById(R.id.buttonVideo6);

        Button [] buttons = {buttonPlayVideo1,buttonPlayVideo2,buttonPlayVideo3,buttonPlayVideo4,buttonPlayVideo5,buttonPlayVideo6 } ;



        //Local Database (Dictionary) to connect between each video file and its matching sound.
        final Map<Integer, Integer> videoToSoundMap = new HashMap<Integer, Integer>();
        videoToSoundMap.put(R.raw.agree,R.raw.agree_sound);
        videoToSoundMap.put(R.raw.byebye,R.raw.byebye_sound);
        videoToSoundMap.put(R.raw.disagree,R.raw.disagree_sound);
        videoToSoundMap.put(R.raw.drink_coke,R.raw.drink_coke_sound);
        videoToSoundMap.put(R.raw.drink_tea,R.raw.drink_tea_sound);
        videoToSoundMap.put(R.raw.drink_water,R.raw.drink_water_sound);
        videoToSoundMap.put(R.raw.eat_bamba,R.raw.eat_bamba_sound);
        videoToSoundMap.put(R.raw.eat_sandwich,R.raw.eat_sandwich_sound);
        videoToSoundMap.put(R.raw.hello,R.raw.hello_sound);
        videoToSoundMap.put(R.raw.me,R.raw.me_sound);
        videoToSoundMap.put(R.raw.music,R.raw.music_sound);
        videoToSoundMap.put(R.raw.thanks,R.raw.thanks_sound);

        final Map<Integer, Integer> videoToImage = new HashMap<Integer, Integer>();
        videoToImage.put(R.raw.agree,R.drawable.agree_pic);
        videoToImage.put(R.raw.byebye,R.drawable.byebye_pic);
        videoToImage.put(R.raw.disagree,R.drawable.disagree_pic);
        videoToImage.put(R.raw.drink_coke,R.drawable.drink_coke_pic);
        videoToImage.put(R.raw.drink_tea,R.drawable.drink_tea_pic);
        videoToImage.put(R.raw.drink_water,R.drawable.drink_water_pic);
        videoToImage.put(R.raw.eat_bamba,R.drawable.eat_bamba_pic);
        videoToImage.put(R.raw.eat_sandwich,R.drawable.eat_sandwich_pic);
        videoToImage.put(R.raw.hello,R.drawable.hello_pic);
        videoToImage.put(R.raw.me,R.drawable.me_pic);
        videoToImage.put(R.raw.music,R.drawable.music_pic);
        videoToImage.put(R.raw.thanks,R.drawable.thanks_pic);



        final int frameOne = R.id.videoView1;
        final int frameTwo = R.id.videoView2;
        final int frameThree = R.id.videoView3;
        final int frameFour = R.id.videoView4;
        final int frameFive = R.id.videoView5;
        final int frameSix = R.id.videoView6;



        final int frameArr [] = {frameOne,frameTwo,frameThree,frameFour,frameFive,frameSix};



        //On seek Loop
        for(int i = 0; i<childVideoList.size() && i<LIMIT;i++)
        {
            //Set Buttons
            buttons[i].setBackground(getDrawable(videoToImage.get(Integer.parseInt(childVideoList.get(i)))));

            VideoView v = (VideoView)findViewById(frameArr[i]);
            String uriPath = "android.resource://com.gifmyneeds/" + childVideoList.get(i);
            Uri uri2 = Uri.parse(uriPath);
            v.setVideoURI(uri2);
            v.requestFocus();
            v.seekTo(1500);
        }


        int index = 0;



        buttonPlayVideo1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonPlayVideo1.setBackgroundColor(Color.TRANSPARENT);

                VideoView v2 = (VideoView) findViewById(frameOne);
                if(childVideoList.size()>0 && Integer.parseInt(childVideoList.get(0)) != 0) {

                    stopPlaying();
                    mp = MediaPlayer.create(getApplicationContext(),videoToSoundMap.get(Integer.parseInt(childVideoList.get(0))));
                    mp.start();
                    String uriPath = "android.resource://com.gifmyneeds/" + childVideoList.get(0);
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

                v2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        buttonPlayVideo1.setBackground(getDrawable(videoToImage.get(Integer.parseInt(childVideoList.get(0)))));
                    }
                });

            }
        });

        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonPlayVideo2.setBackgroundColor(Color.TRANSPARENT);

                VideoView v2 = (VideoView) findViewById(frameTwo);
                if(childVideoList.size()>1 && Integer.parseInt(childVideoList.get(1)) != 0) {


                    stopPlaying();
                    mp = MediaPlayer.create(getApplicationContext(),videoToSoundMap.get(Integer.parseInt(childVideoList.get(1))));
                    mp.start();
                    String uriPath = "android.resource://com.gifmyneeds/" + childVideoList.get(1);
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

                v2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        buttonPlayVideo2.setBackground(getDrawable(videoToImage.get(Integer.parseInt(childVideoList.get(1)))));
                    }
                });

            }
        });

        buttonPlayVideo3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonPlayVideo3.setBackgroundColor(Color.TRANSPARENT);

                VideoView v2 = (VideoView) findViewById(frameThree);
                if(childVideoList.size()>2 && Integer.parseInt(childVideoList.get(2)) != 0){

                    stopPlaying();
                    mp = MediaPlayer.create(getApplicationContext(),videoToSoundMap.get(Integer.parseInt(childVideoList.get(2))));
                    mp.start();
                    String uriPath = "android.resource://com.gifmyneeds/" + childVideoList.get(2);
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

                v2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        buttonPlayVideo3.setBackground(getDrawable(videoToImage.get(Integer.parseInt(childVideoList.get(2)))));
                    }
                });

            }
        });

        buttonPlayVideo4.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonPlayVideo4.setBackgroundColor(Color.TRANSPARENT);

                VideoView v2 = (VideoView) findViewById(frameFour);

                if(childVideoList.size()>3 && Integer.parseInt(childVideoList.get(3)) != 0) {

                    stopPlaying();
                    mp = MediaPlayer.create(getApplicationContext(),videoToSoundMap.get(Integer.parseInt(childVideoList.get(3))));
                    mp.start();
                    String uriPath = "android.resource://com.gifmyneeds/" + childVideoList.get(3);
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

                v2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        buttonPlayVideo4.setBackground(getDrawable(videoToImage.get(Integer.parseInt(childVideoList.get(3)))));
                    }
                });

            }
        });

        buttonPlayVideo5.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonPlayVideo5.setBackgroundColor(Color.TRANSPARENT);

                VideoView v2 = (VideoView) findViewById(frameFive);
                if(childVideoList.size()>4 && Integer.parseInt(childVideoList.get(4)) != 0) {

                    stopPlaying();
                    mp = MediaPlayer.create(getApplicationContext(),videoToSoundMap.get(Integer.parseInt(childVideoList.get(4))));
                    mp.start();
                    String uriPath = "android.resource://com.gifmyneeds/" + childVideoList.get(4);
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

                v2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        buttonPlayVideo5.setBackground(getDrawable(videoToImage.get(Integer.parseInt(childVideoList.get(4)))));
                    }
                });

            }
        });

        buttonPlayVideo6.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonPlayVideo6.setBackgroundColor(Color.TRANSPARENT);

                VideoView v2 = (VideoView) findViewById(frameSix);
                if(childVideoList.size()>5 && Integer.parseInt(childVideoList.get(5)) != 0) {

                    stopPlaying();
                    mp = MediaPlayer.create(getApplicationContext(),videoToSoundMap.get(Integer.parseInt(childVideoList.get(5))));
                    mp.start();
                    String uriPath = "android.resource://com.gifmyneeds/" + childVideoList.get(5);
                    Uri uri2 = Uri.parse(uriPath);
                    v2.setVideoURI(uri2);
                    v2.requestFocus();
                    v2.start();
                }

                v2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        buttonPlayVideo6.setBackground(getDrawable(videoToImage.get(Integer.parseInt(childVideoList.get(5)))));
                    }
                });

            }
        });


    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}