package com.example.codex;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MapsActivity extends AppCompatActivity {
    EditText source,destination;
    Button trace;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        source = findViewById(R.id.source);
        destination = findViewById(R.id.destination);
        trace = findViewById(R.id.BtnGo);

        trace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String source1 = source.getText().toString().trim();
                String destination1 = destination.getText().toString().trim();

                if (source1.equals("")&&destination1.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter both Locations",Toast.LENGTH_SHORT).show();
                }
                else {
                    DisplayTrack(source1,destination1);
                }
            }

            private void DisplayTrack(String source1, String destination1) {
                try {
                    Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+source1+"/"+destination1);
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
                catch (ActivityNotFoundException e){
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }



}