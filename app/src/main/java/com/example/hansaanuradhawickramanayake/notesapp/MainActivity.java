package com.example.hansaanuradhawickramanayake.notesapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView notesListView;

    static ArrayList<String> notesArrayList;
    static ArrayAdapter<String> arrayAdapter;

    static String tappedNote = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesListView = findViewById(R.id.notesListView);

        notesArrayList = new ArrayList<>();
        notesArrayList.add("Example note");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notesArrayList);

        notesListView.setAdapter(arrayAdapter);



        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tappedNote = notesArrayList.get(position).toString();

                goToNewActivity(tappedNote);
            }
        });

        notesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you definitely want to delete this?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                notesArrayList.remove(position);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_main, menu);

        return super.onCreateOptionsMenu(menu);






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch (item.getItemId()){

            case R.id.newNotes :
                goToNewActivity("");
                return true;

            default:
                return false;
        }


    }

    public void goToNewActivity(String note){

        Intent intent = new Intent(MainActivity.this, NewNotesActivity.class);
        intent.putExtra("note", note);
        startActivity(intent);
    }


}
