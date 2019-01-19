package com.exception.hackaznotetest;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static ArrayAdapter<String> arrayAdapter;
    public static ArrayList<String > notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);
//        for(int i = 0; i < 10; i++){
//            notes.add(i + " items here");
//        }

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, notes.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), noteActivity.class);
                intent.putExtra("noteID", position);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                notes.add("");
                Intent intent = new Intent(getApplicationContext(), noteActivity.class);
//                intent.putExtra("noteID", notes.size()-1);
                startActivity(intent);
            }
        });
    }
}
