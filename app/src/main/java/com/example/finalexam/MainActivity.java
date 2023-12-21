package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText eventIDs, eventName, eventDate, eventLocation, eventDescription;
    Button btnRegister, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventIDs = findViewById(R.id.eventID);
        eventName = findViewById(R.id.eventName);
        eventDate = findViewById(R.id.eventDate);
        eventLocation = findViewById(R.id.eventLocation);
        eventDescription = findViewById(R.id.eventDescription);

        btnRegister = findViewById(R.id.addEvent);
        btnRegister.setOnClickListener(v -> setInputData());

        btnShow = findViewById(R.id.showEvent);
        btnShow.setOnClickListener(v -> setShow());
    }
    public void setInputData() {
        String eventID = eventIDs.getText().toString();
        String name = eventName.getText().toString();
        String date = eventDate.getText().toString();
        String location = eventLocation.getText().toString();
        String description = eventDescription.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String URL = "http://192.168.245.253/finalexam/register.php";

        if (eventID.isEmpty() || name.isEmpty() || date.isEmpty() || location.isEmpty() || description.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill all the form", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                Log.d("response", response);
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            }, error -> {
                Log.d("error", error.toString());
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("eventID", eventID);
                    params.put("name", name);
                    params.put("date", date);
                    params.put("location", location);
                    params.put("description", description);
                    return params;
                }
            };
            queue.add(stringRequest);
        }
    }
    public void setShow () {
        Intent intent = new Intent(this, EventList.class);
        startActivity(intent);
    }
}