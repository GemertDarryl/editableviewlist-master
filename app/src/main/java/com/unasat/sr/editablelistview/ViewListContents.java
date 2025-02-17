package com.unasat.sr.editablelistview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContents  extends AppCompatActivity {

    DatabaseHelper mylist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);
        mylist = new DatabaseHelper(this);
        ListView listView = (ListView) findViewById(R.id.listView);


        ArrayList<String> theList = new ArrayList<>();
        Cursor data =mylist.getListContents();

       if(data.getCount()==0){
           Toast.makeText(ViewListContents.this,"The database was Empty",Toast.LENGTH_LONG).show();
       } else{
           while (data.moveToNext()){
               theList.add(data.getString(2));
               ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
               listView.setAdapter(listAdapter);

           }
       }
    }
}
