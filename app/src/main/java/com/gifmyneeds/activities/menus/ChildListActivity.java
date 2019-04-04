package com.gifmyneeds.activities.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.gifmyneeds.R;
import com.gifmyneeds.activities.child.AddChildActivity;
import com.gifmyneeds.activities.child.GifBoardActivity;
import com.gifmyneeds.activities.user.SelectCategoryForBoardActivity;
import com.gifmyneeds.adapters.ChildListAdapter;

import com.gifmyneeds.database.ChildDBApi;
import com.gifmyneeds.models.Child;
import com.gifmyneeds.models.User;

import java.util.ArrayList;
import java.util.List;

public class ChildListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,View.OnClickListener {

        private static final String TAG = "ChildListActivity";
        static final int REQUEST_ADDCHILD = 0;

        private ArrayList<Child> childsList;
        private ChildListAdapter adapter;
        private Button btnAddChild,btnSeleChild, btnEditChild;
        private ListView childListView;
        private SearchView childSearchView;
        private Child selectedChild;
        private User userLogin;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.child_list_activity_layout);

            childListView = (ListView) findViewById(R.id.listView);
            childSearchView = (SearchView) findViewById(R.id.searchView);
            btnAddChild = (Button) findViewById(R.id.btnAddChild);
            btnSeleChild = (Button) findViewById(R.id.btnSelectChild);
            btnEditChild = (Button) findViewById(R.id.btnEditChildBoard);


            btnAddChild.setOnClickListener(this);
            btnSeleChild.setOnClickListener(this);
            btnEditChild.setOnClickListener(this);
            childListView.setTextFilterEnabled(true);
            childListView.setAdapter(adapter);

            Intent incomingIntent = getIntent();
            userLogin = (User) incomingIntent.getSerializableExtra("loginUser");

            childsList = new ArrayList<>();
            addChild();
            adapter = new ChildListAdapter(this, R.layout.adapter_view_child_list_layout, childsList, userLogin);


            childListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    selectedChild = adapter.getItem(position);
                    view.setSelected(true);
                    Log.d(TAG,selectedChild.getFullName());
                }
            });


            setupSearchView();
        }


        @Override
        public boolean onQueryTextChange(String newText)
        {
            if (TextUtils.isEmpty(newText)) {
                childListView.clearTextFilter();
            } else {
                childListView.setFilterText(newText);
            }
            return true;
        }

        @Override
        public boolean onQueryTextSubmit(String query)
        {
            return false;
        }


        @Override
        protected void onResume() {
            super.onResume();
            ChildListAdapter adapter = new ChildListAdapter(this, R.layout.adapter_view_child_list_layout, childsList, userLogin);
            childListView.setAdapter(adapter);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_ADDCHILD) {
                if (resultCode == RESULT_OK) {
                    Child incomingChild = (Child)data.getSerializableExtra("child");
                    childsList.add(incomingChild);
                }
            }
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.btnAddChild:
                    Intent intent = new Intent(ChildListActivity.this, AddChildActivity.class);
                    intent.putExtra("parent", userLogin);
                    startActivityForResult(intent, REQUEST_ADDCHILD);
                    break;

                case R.id.btnSelectChild:
                    if (selectedChild!=null) {
                        Intent i = new Intent(ChildListActivity.this, GifBoardActivity.class);
                        i.putExtra("id",selectedChild.getId());
                        startActivity(i);
//                        finish();
                    }
                    else
                        Toast.makeText(this,R.string.no_selected_child, Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnEditChildBoard:

                    if (selectedChild!=null) {
                        Intent i = new Intent(ChildListActivity.this, SelectCategoryForBoardActivity.class);
                        i.putExtra("id",selectedChild);
                        startActivity(i);
                        //finish();
                    }
                    else
                        Toast.makeText(this,R.string.no_selected_child, Toast.LENGTH_LONG).show();
                    break;
            }
        }

        private void setupSearchView()
        {
            childSearchView.setIconifiedByDefault(false);
            childSearchView.setOnQueryTextListener(this);
            childSearchView.setSubmitButtonEnabled(true);
            childSearchView.setQueryHint("Search Here");
        }

        private void addChild(){
            Log.d(TAG, "addChild: add child function");
            List<Child> l = ChildDBApi.getChildrenOfParent(this, userLogin.getEmail()); //TODO:
            if (l != null) {
                Log.d(TAG, "addChild: " + l.toString());
                childsList = new ArrayList<>(l);
            }
            else {
                Log.d(TAG, "addChild: NULL!!!!!!!!!!!!!");
                childsList = new ArrayList<>();
            }

        }
    }
