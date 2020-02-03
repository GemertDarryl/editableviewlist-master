package com.unasat.sr.editablelistview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;
//NavigationView navigationView = findViewById(R.id.nav_view);
//navigationView.setNavigationItemSelectedListener(this);


    DatabaseHelper mylist;
    //Button btn_Add, btnView;
    //EditText editText;

    static TextView placeTextView;
    static TextView temperatureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        placeTextView = (TextView) findViewById(R.id.nameTextView);
        temperatureTextView = (TextView)  findViewById(R.id.temperatureTextView);

        Weather task = new Weather();

        task.execute("https://api.openweathermap.org/data/2.5/weather?q=Paramaribo,SR&appid=baf0fb2a90614a81d2c70ebdaed4c8b8&units=metric");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Als het scherm draait(rotate) zou je makkelijk weer komen op de eerste scherm MessageFragement, dus in het volgende check ik als een scherm geladen is.
        if (savedInstanceState == null) {
            Intent intent1 = new Intent(MainActivity.this, InsertClass.class);
        startActivity(intent1);
//Eerste scherm als je app start
            // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Login()).commit();
            //         navigationView.setCheckedItem(R.id.nav_message)
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        switch (Item.getItemId()) {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
                break;
            case R.id.nav_share:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
                break;
            case R.id.nav_send:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SendFragment()).commit();
                break;
            case R.id.nav_profile:
                Toast.makeText(this, "Setting Profile under construction", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_list:

                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);

                break;
            case R.id.nav_insert:

                Intent intent1 = new Intent(MainActivity.this, InsertClass.class);
                startActivity(intent1);

                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }


}
/*        editText =(EditText)findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length() != 0){
                    AddData(newEntry);
                    editText.setText("");

                }else {
                    Toast.makeText(MainActivity.this,"You must put something into the text field",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"Succesfully entered",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }
}
*/
