package com.infisoln.siddhant.note_taking_app_sharedprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> arrayList = new ArrayList<>();
    ArrayList<String> notes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final EditText editText = findViewById(R.id.etNote);
        ImageButton btnAdd = findViewById(R.id.btnAddNote);

        Map<String, String> map = (Map<String, String>) sharedPreferences.getAll();
        Set<String> keySet = map.keySet();

        notes = new ArrayList<>(keySet);

        for (int i = 0; i < notes.size(); i++) {
            String title = map.get(notes.get(i));
            String timeStamp = notes.get(i);
            arrayList.add(new Note(title, timeStamp));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final NotesAdapter notesAdapter = new NotesAdapter(arrayList);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notesAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long sec = System.currentTimeMillis();
                String etText = editText.getText().toString();
                if (etText.equals("")) {
                    return;
                }
                editor.putString("" + sec, etText);
                arrayList.add(new Note(editText.getText().toString(), "" + sec));
                notesAdapter.notifyDataSetChanged();
                editor.apply();
                editText.setText("");
            }
        });


    }
}
