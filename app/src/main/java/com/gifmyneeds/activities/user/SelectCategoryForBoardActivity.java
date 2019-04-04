package com.gifmyneeds.activities.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import com.gifmyneeds.R;
import com.gifmyneeds.models.Child;
import com.gifmyneeds.models.ChildGifs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gifmyneeds.utilities.SharedConstants;
import com.google.gson.Gson;
import android.widget.Toast;

public class SelectCategoryForBoardActivity extends AppCompatActivity {

    private Spinner category_spinner;
    private ImageButton add_btn;
    private Button choose_gif_btn;
    private SharedPreferences table_childes_gif;
    private String child_id;
    private ArrayList<String> category_list;
    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_category_for_board_activity_layout);



        category_spinner = (Spinner) findViewById(R.id.categorySpinner);
        add_btn = (ImageButton) findViewById(R.id.imageButton);
        choose_gif_btn = (Button) findViewById(R.id.choose_gif);
        table_childes_gif = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        category_list = new ArrayList<String>();
        choose_gif_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCategoryForBoardActivity.this, SelectGifsForBoardActivity.class);
                startActivity(intent);
                finish();
            }
        });

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
//        }


//         get child id from previous activity
        Intent intent= getIntent();
        Bundle bundle  = intent.getExtras();

        if(bundle != null){
            child_id = bundle.getString("child_id");
        }

        showSpinnerOfCategories();
        addListenerOnButtonAdd();
    }

    public void addListenerOnButtonAdd(){

        add_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SelectCategoryForBoardActivity.this, AddNewCategoryActivity.class);
                intent.putExtra("child_id", child_id);
//                startActivity(intent);
            }
        });
    }

    public void showSpinnerOfCategories(){

        // if child exists in shared preference
        if(table_childes_gif.contains(child_id)){

            List<ChildGifs> list_of_gif = SharedConstants.getChildGifsListFromSharedPreference(child_id, table_childes_gif);

            // take out all categories of child
            for (ChildGifs child_gifs : list_of_gif){
                category_list.add(child_gifs.getCategory());
            }

            // show all categories with spinner
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, category_list);
            category_spinner.setAdapter(adapter);

            addListenerOnSpinner();
        }

    }

    public void addListenerOnSpinner(){

        category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedItemText = (String) parent.getItemAtPosition(position);
                List<ChildGifs> list_of_gif = SharedConstants.getChildGifsListFromSharedPreference(child_id, table_childes_gif);
                ChildGifs obj = new ChildGifs();

                for (ChildGifs child_gifs : list_of_gif){
                    if (selectedItemText == child_gifs.getCategory())
                        obj = child_gifs;
                }



//                // Notify the selected item text
//                Toast.makeText
//                        (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
//                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

//    public void addListenerOnButtonChooseGif(final ChildGifs obj){
//
//        choose_gif_btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(SelectCategoryForBoardActivity.this, SelectGifsForBoardActivity.class);
////                intent.putExtra("child_gif", obj);
//                startActivity(intent);
//            }
//        });
//    }

//    public void addNewChildToPreferences(String child_id){
//        int score = SharedConstants.scoreMap.get(answer);
//        SharedPreferences.Editor score_editor = table_score_prefs.edit();
//
//        //score_editor.clear();
//
//        score_editor.putInt("question1", score);
//
//        score_editor.commit();
//    }


}
