package com.example.hansaanuradhawickramanayake.notesapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class NewNotesActivity extends AppCompatActivity {

    EditText newNotesEditText;


    static String  note;
    static int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);

        newNotesEditText = findViewById(R.id.newNotesEditText);


        Intent intent = getIntent();
        note = intent.getStringExtra("note");
        noteId = intent.getIntExtra("noteId", -1);
        Toast.makeText(this, Integer.toString(noteId), Toast.LENGTH_SHORT).show();

        newNotesEditText.setText(note);


    }

    @Override
    public void onBackPressed()
    {

        super.onBackPressed();

        if (note.equals("") && noteId == -1){


            MainActivity.notesArrayList.add(newNotesEditText.getText().toString());

        } else if (!note.equals("") && noteId != -1){

            MainActivity.notesArrayList.set(noteId,newNotesEditText.getText().toString());


        }
        MainActivity.arrayAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();



    }
}
