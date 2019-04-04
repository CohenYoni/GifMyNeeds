package com.gifmyneeds.activities.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.gifmyneeds.R;
import com.gifmyneeds.activities.MainActivity;
import com.gifmyneeds.models.Child;
import com.gifmyneeds.models.ChildGifs;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectGifsForBoardActivity extends AppCompatActivity implements View.OnClickListener  {

    private ArrayList<String> allVideo ;
    private ArrayList<String> str = new ArrayList<String>();
    private  ChildGifs childGifs;
    private Button submit;

    private static final String TAG = "SelectGifsForBoardActiv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_gifs_for_board_activity_layout);
        submit = (Button) findViewById(R.id.SubmitButton);
        childGifs = moc();


        Intent incomingIntent = getIntent();
        Bundle bundle = incomingIntent.getExtras();
//        childGifs = (ChildGifs) incomingIntent.getSerializableExtra("child_gif");

        childGifs.setPathGif(new ArrayList<String>());
        //new ChildGifs("1234","eat",str);



        getWindow().setFormat(PixelFormat.UNKNOWN);

        //Set Button------------------------------------------------------
        Button buttonPlayVideo1 = (Button)findViewById(R.id.button_Video1_1);
        Button buttonPlayVideo2 = (Button)findViewById(R.id.button_Video1_2);
        Button buttonPlayVideo3 = (Button)findViewById(R.id.button_Video2_1);
        Button buttonPlayVideo4 = (Button)findViewById(R.id.button_Video2_2);
        Button buttonPlayVideo5 = (Button)findViewById(R.id.button_Video3_1);
        Button buttonPlayVideo6 = (Button)findViewById(R.id.button_Video3_2);
        Button buttonPlayVideo7 = (Button)findViewById(R.id.button_Video4_1);
        Button buttonPlayVideo8 = (Button)findViewById(R.id.button_Video4_2);
        Button buttonPlayVideo9 = (Button)findViewById(R.id.button_Video5_1);
        Button buttonPlayVideo10 = (Button)findViewById(R.id.button_Video5_2);
        Button buttonPlayVideo11 = (Button)findViewById(R.id.button_Video6_1);
        Button buttonPlayVideo12 = (Button)findViewById(R.id.button_Video6_2);
        buttonPlayVideo1.setText("Add");
        buttonPlayVideo2.setText("Add");
        buttonPlayVideo3.setText("Add");
        buttonPlayVideo4.setText("Add");
        buttonPlayVideo5.setText("Add");
        buttonPlayVideo6.setText("Add");
        buttonPlayVideo7.setText("Add");
        buttonPlayVideo8.setText("Add");
        buttonPlayVideo9.setText("Add");
        buttonPlayVideo10.setText("Add");
        buttonPlayVideo11.setText("Add");
        buttonPlayVideo12.setText("Add");
        //-----------------------------------------------------------------

        //gou lisineron butten---------------------------------------------
        buttonPlayVideo1.setOnClickListener(this);
        buttonPlayVideo2.setOnClickListener(this);
        buttonPlayVideo3.setOnClickListener(this);
        buttonPlayVideo4.setOnClickListener(this);
        buttonPlayVideo5.setOnClickListener(this);
        buttonPlayVideo6.setOnClickListener(this);
        buttonPlayVideo7.setOnClickListener(this);
        buttonPlayVideo8.setOnClickListener(this);
        buttonPlayVideo9.setOnClickListener(this);
        buttonPlayVideo10.setOnClickListener(this);
        buttonPlayVideo11.setOnClickListener(this);
        buttonPlayVideo12.setOnClickListener(this);
        submit.setOnClickListener(this);

        //-----------------------------------------------------------------


        VideoView video;
        String uriPath;
        Uri uri;
        //Initialize all videos--------------------------------------------


        //row 1--------------------------------------------------------
        video = (VideoView)findViewById(R.id.video_View1_1);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.agree;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);

        video = (VideoView)findViewById(R.id.video_View1_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.byebye;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);
        //---------------------------------------------------------------


        //row 2--------------------------------------------------------
        video = (VideoView)findViewById(R.id.video_View2_1);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.disagree;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);

        video = (VideoView)findViewById(R.id.video_View2_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.drink_coke;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);
        //---------------------------------------------------------------

        //row 3--------------------------------------------------------
        video = (VideoView)findViewById(R.id.video_View3_1);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.drink_tea;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);

        video = (VideoView)findViewById(R.id.video_View3_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.drink_water;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);
        //---------------------------------------------------------------
        //row 4--------------------------------------------------------
        video = (VideoView)findViewById(R.id.video_View4_1);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.eat_bamba;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);

        video = (VideoView)findViewById(R.id.video_View4_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.eat_sandwich;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);
        //---------------------------------------------------------------
        //row 5--------------------------------------------------------
        video = (VideoView)findViewById(R.id.video_View5_1);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.hello;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);

        video = (VideoView)findViewById(R.id.video_View5_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.me;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);
        //---------------------------------------------------------------
        //row 6--------------------------------------------------------
        video = (VideoView)findViewById(R.id.video_View6_1);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.music;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);

        video = (VideoView)findViewById(R.id.video_View6_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.thanks;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);
        //---------------------------------------------------------------
        //row 1--------------------------------------------------------
        video = (VideoView)findViewById(R.id.video_View1_1);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.agree;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);

        video = (VideoView)findViewById(R.id.video_View1_2);
        uriPath = "android.resource://com.gifmyneeds/" + R.raw.byebye;
        uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.seekTo(1);
        //---------------------------------------------------------------
        //-----------------------------------------------------------------


//        Intent intent = new Intent(SelectCategoryForBoardActivity.this,
//                SelectGifsForBoardActivity.class);
//        intent.putExtra("key", "value");
//        startActivity(intent);
        //String value = incomingIntent.getStringExtra("key");

        //getGifsByCategory(childGifs.getCategory());

    }

    private void fillAllVideo(){
        allVideo= new ArrayList<String>();
        String str ="android.resource://com.gifmyneeds/" + R.raw.agree;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.byebye;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.disagree;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.drink_coke;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.drink_water;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.drink_tea;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.eat_bamba;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.eat_sandwich;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.hello;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.music;
        allVideo.add(str);
        str ="android.resource://com.gifmyneeds/" + R.raw.thanks;
        allVideo.add(str);

    }


    private void addPath(String txt){
        if(childGifs.getPathGif() ==null)
            childGifs.setPathGif(new ArrayList<String>());

        childGifs.getPathGif().add(txt);
        Log.d(TAG, "addPath: "+childGifs.getPathGif().toString());
    }


    private void removePath(String txt){
        if(childGifs.getPathGif() ==null)
            childGifs.setPathGif(new ArrayList<String>());

        childGifs.getPathGif().remove(txt);
        Log.d(TAG, "addPath: "+childGifs.getPathGif().toString());
    }


    private ArrayList<String> getCategoryVideos(String category){
        fillAllVideo();//fill allVideo with all video

        ArrayList<String> list = new ArrayList<String>();
        String str = "android.resource://com.gifmyneeds/"+category;

        for (int i=0; i<allVideo.size() ; i++ ){
            if(allVideo.get(i).contains(str)){
                list.add(allVideo.get(i));
            }

        }
        return list;


    }

    @Override
    public void onClick(View view) {
        String uriPath;
        Uri uri;
        VideoView video;
        Button btn;
        switch(view.getId()) {
            //row1------------------
            case R.id.button_Video1_1:
                btn = (Button) findViewById(R.id.button_Video1_1);
                video = (VideoView)findViewById(R.id.video_View1_1);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.agree;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();
                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");

                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;

            case R.id.button_Video1_2:
                btn = (Button) findViewById(R.id.button_Video1_2);
                video = (VideoView)findViewById(R.id.video_View1_2);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.byebye;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();
                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");
                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
             break;
            //-----------------------------------

            //row2------------------
            case R.id.button_Video2_1:
                btn = (Button) findViewById(R.id.button_Video2_1);
                video = (VideoView)findViewById(R.id.video_View2_1);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.disagree;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();

                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");

                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            case R.id.button_Video2_2:
                btn = (Button) findViewById(R.id.button_Video2_2);
                video = (VideoView)findViewById(R.id.video_View2_2);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.drink_coke;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();
                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");
                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            //-----------------------------------
            //row3------------------
            case R.id.button_Video3_1:
                btn = (Button) findViewById(R.id.button_Video3_1);
                video = (VideoView)findViewById(R.id.video_View3_1);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.drink_tea;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();

                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");

                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            case R.id.button_Video3_2:
                btn = (Button) findViewById(R.id.button_Video3_2);
                video = (VideoView)findViewById(R.id.video_View3_2);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.drink_water;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();
                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");
                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            //-----------------------------------
            //row5------------------
            case R.id.button_Video4_1:
                btn = (Button) findViewById(R.id.button_Video4_1);
                video = (VideoView)findViewById(R.id.video_View4_1);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.eat_bamba;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();

                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");

                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            case R.id.button_Video4_2:
                btn = (Button) findViewById(R.id.button_Video4_2);
                video = (VideoView)findViewById(R.id.video_View4_2);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.eat_sandwich;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();
                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");
                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            //-----------------------------------
            //row5------------------
            case R.id.button_Video5_1:
                btn = (Button) findViewById(R.id.button_Video5_1);
                video = (VideoView)findViewById(R.id.video_View5_1);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.hello;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();

                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");

                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            case R.id.button_Video5_2:
                btn = (Button) findViewById(R.id.button_Video5_2);
                video = (VideoView)findViewById(R.id.video_View5_2);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.me;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();
                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");
                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            //-----------------------------------
            //row6------------------
            case R.id.button_Video6_1:
                btn = (Button) findViewById(R.id.button_Video6_1);
                video = (VideoView)findViewById(R.id.video_View6_1);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.music;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();

                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");

                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            case R.id.button_Video6_2:
                btn = (Button) findViewById(R.id.button_Video6_2);
                video = (VideoView)findViewById(R.id.video_View6_2);
                uriPath = "android.resource://com.gifmyneeds/" + R.raw.thanks;
                uri = Uri.parse(uriPath);
                video.setVideoURI(uri);
                video.requestFocus();
                video.start();
                if(btn.getText()=="Add"){
                    addPath(uriPath);
                    btn.setText("Remove");
                }
                else{
                    removePath(uriPath);
                    btn.setText("Add");
                }
                break;
            //-----------------------------------
            case R.id.SubmitButton:

//                Intent intent = new Intent(SelectGifsForBoardActivity.this,
//                        SelectCategoryForBoardActivity.class);


                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Gson gson = new Gson();
                String json = gson.toJson(childGifs);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("child_gif", json);
                editor.commit();



//                intent.putExtra("child_gif", childGifs);
//                startActivity(intent);
                finish();



                break;
        }

    }

    private ChildGifs moc() {
//        if(count == 0)
//        {
//            String[] array = {"bla1", "bla2", "bla3"};
//
//            ArrayList<String> lst = new ArrayList<String>(Arrays.asList(array));
//
//            Intent intent  = getIntent();
//            Child child = (Child) intent.getSerializableExtra("id");
//
//            child_id = child.getId();
//
//            List<ChildGifs> testList= new ArrayList<ChildGifs>();
//
//            ChildGifs obj = new ChildGifs(child_id, "food", lst);
//            ChildGifs obj1 = new ChildGifs(child_id, "drink", lst);
//
//            testList.add(obj);
//            testList.add(obj1);
//
//            Gson gson = new Gson();
//            String json = gson.toJson(testList);
//
//            SharedPreferences.Editor editor = table_childes_gif.edit();
//
//            //editor.clear();
//
//            editor.putString(child_id, json);
//
//            editor.commit();
//            count++;
        ChildGifs childGifs = new ChildGifs("205508955","food",null);
        return childGifs;
        }


}
