package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EventDetails extends AppCompatActivity {

    private android.content.Intent Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        TextView eventDetails = findViewById(R.id.eventDetails);

        Intent = getIntent();
        String eventID = getIntent().getStringExtra("eventID");

        eventDetails.setText(String.format("Event ID: %s", eventID));
    }
}