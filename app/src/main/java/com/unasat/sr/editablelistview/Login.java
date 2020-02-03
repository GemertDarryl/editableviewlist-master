package com.unasat.sr.editablelistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
//import android.MenuItem;
import android.widget.EditText;
import android.view.View;


        public class Login extends Activity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

            }
            public void onButtonClick(View v){
                if(v.getId() == R.id.Blogin)
                {
                    //EditText a = (EditText)findViewById(R.id.TFusername);
                    //String str = a.getText().toString();

                    Intent i = new Intent(Login.this,MainActivity.class);
                    //i.putExtra("Username",str);
                    startActivity(i);
                }
            }


        }
