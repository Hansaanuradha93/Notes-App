package com.example.hansaanuradhawickramanayake.notesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.hansaanuradhawickramanayake.notesapp.MainActivity.arrayAdapter;

public class NewNotesActivity extends AppCompatActivity {

    EditText newNotesEditText;

    static SharedPreferences sharedPreferences;



    static String  note;
    static int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);

        newNotesEditText = findViewById(R.id.newNotesEditText);

        sharedPreferences = this.getSharedPreferences("com.example.hansaanuradhawickramanayake.notesapp", Context.MODE_PRIVATE);

        Intent intent = getIntent();
        note = intent.getStringExtra("note");
        noteId = intent.getIntExtra("noteId", -1);


        if (noteId != -1){
            newNotesEditText.setText(note);

        } else {

            MainActivity.notesArrayList.add("");
            noteId = MainActivity.notesArrayList.size() - 1;
        }

        newNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                MainActivity.notesArrayList.set(noteId,newNotesEditText.getText().toString());

                arrayAdapter.notifyDataSetChanged();



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


}
