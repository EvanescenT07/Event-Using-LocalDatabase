package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class EventList extends AppCompatActivity {

  ListView listEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        setList();

    }
    public void setList() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String URL = "http://192.168.245.253/finalexam/show.php";
        StringRequest stringRequest = new StringRequest(URL, response -> {
            ArrayList<String> list = new ArrayList<>();
            String[] data = response.split("\n");
            for (int i = 0; i < data.length; i++) {
                list.add(data[i]);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            ListView listView = findViewById(R.id.listViewEvents);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener((parent, view, position, id) -> {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), EventDetails.class);
                intent.putExtra("eventID", selectedItem);
                startActivity(intent);
            });
        }, error -> {
            listEvent.setAdapter(null);
        });
        queue.add(stringRequest);
    }
}