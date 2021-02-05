package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText log, pas;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnen);
        btn.setOnClickListener(this);
        log = findViewById(R.id.textLog);
        pas = findViewById(R.id.textPas);
    }

    @Override
    public void onClick(View v) {
        if(log.getText().toString().equals("Katya") && pas.getText().toString().equals("123")){
            toast = Toast.makeText(getBaseContext(), R.string.right, Toast.LENGTH_SHORT);
            TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
            text.setTextColor(Color.GREEN);
            toast.show();

            log.setText(null);
            pas.setText(null);
        }
        else{
            toast = Toast.makeText(getBaseContext(), R.string.error, Toast.LENGTH_SHORT);
            TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
            text.setTextColor(Color.RED);
            toast.show();
            Intent i = new Intent(this, MainActivity2.class);
            startActivityForResult(i,1);
            pas.setText(null);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data==null){
            return;
        }
        log.setText(data.getStringExtra("key"));

    }
}