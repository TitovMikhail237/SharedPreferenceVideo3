package com.example.sharedpreferencevideo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button store, retrieve, delete;
    EditText username, password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        store = findViewById(R.id.buttonStore);
        retrieve = findViewById(R.id.buttonRetrieve);
        delete = findViewById(R.id.buttonDelete);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_LONG).show();

            }
        });
        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sharedPreferences.contains("username")){
                    username.setText(sharedPreferences.getString("username", ""));
                }
                if(sharedPreferences.contains("password")){
                    password.setText(sharedPreferences.getString("password", ""));
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                username.setText("");
                password.setText("");
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
            }
        });
    }
}