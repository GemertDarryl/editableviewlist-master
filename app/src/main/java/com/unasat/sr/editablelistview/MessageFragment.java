package com.unasat.sr.editablelistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

public class MessageFragment extends Fragment {

    @Nullable
    @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle saverInstanceState){
        return inflater.inflate(R.layout.fragment_message,container,false);
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
