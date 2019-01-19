package com.exception.hackaznotetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class noteActivity extends AppCompatActivity {

    EditText editText;
    Button save;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        editText = findViewById(R.id.editText);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);

        Intent intent = getIntent();
        final int noteID = intent.getIntExtra("noteID", -1); // default -1 
        if(noteID != -1){
            editText.setText(MainActivity.notes.get(noteID));
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().equals("")) {
                    if(noteID == -1){
                        MainActivity.notes.add(0, editText.getText().toString());
                    }else {
                        MainActivity.notes.set(noteID, editText.getText().toString());
                    }
                }else {
                    MainActivity.notes.remove("");
                }
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(noteID != -1){
                    MainActivity.notes.remove(noteID);
                }
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });
    }
}
