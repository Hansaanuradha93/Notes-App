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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);



        Intent intent = getIntent();
        String intentData = intent.getStringExtra("note");

        Toast.makeText(this, intentData, Toast.LENGTH_SHORT).show();


        //newNotesEditText.setText(intentData);
    }

    @Override
    public void onBackPressed()
    {

        newNotesEditText = findViewById(R.id.newNotesEditText);


        String newNotes = newNotesEditText.getText().toString();


            if (newNotes.equals("")){

                Toast.makeText(this, "Your note is empty", Toast.LENGTH_SHORT).show();

            } else {

                MainActivity.notesArrayList.add(newNotes);

                MainActivity.arrayAdapter.notifyDataSetChanged();

                Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();

            }


        super.onBackPressed();


    }
}
