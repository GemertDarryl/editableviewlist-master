package com.unasat.sr.editablelistview;

import java.util.Date;
import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
import android.view.View;
//import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertClass  extends AppCompatActivity {
    DatabaseHelper mylist;
    Button btn_Add;
    EditText editDatum;
    EditText editStarttime;
    EditText editEndtime;
    EditText editLocatie;
    EditText editInvoer;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_layout);
        mylist = new DatabaseHelper(this);

        editDatum =  (EditText) findViewById(R.id.editdatum);
        editStarttime =(EditText) findViewById(R.id.editstarttime);
        editEndtime =(EditText) findViewById(R.id.edit_endtime);
        editLocatie =(EditText) findViewById(R.id.edit_locatie);
        editInvoer =(EditText) findViewById(R.id.edit_invoer);
        btn_Add = (Button) findViewById(R.id.btn_add);
        AddData();
    }

    public void AddData(){
        btn_Add.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                       //omdat de insertdata metho een boolean is gaan we hier ook boolean gebruikken om een resultaat terug te krijgen
                       boolean isInserted = mylist.insertData(editDatum.getText().toString(),
                                editStarttime.getText().toString(),editEndtime.getText().toString(),
                                editLocatie.getText().toString(),editInvoer.getText().toString());
                       if(isInserted= true){
                           Toast.makeText(InsertClass.this,"Succesfully entered",Toast.LENGTH_LONG).show();
                       ClearEditTextAfterDoneTask();}
                     else {
                           Toast.makeText(InsertClass.this, "Something went wrong", Toast.LENGTH_LONG).show();
                       }

                    }
                }
        );

        }
        public void ClearEditTextAfterDoneTask(){
            editDatum.getText().clear();
            editStarttime.getText().clear();
            editEndtime.getText().clear();
            editLocatie.getText().clear();
            editInvoer.getText().clear();

        }
    }


