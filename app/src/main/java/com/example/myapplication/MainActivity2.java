package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
Button btn;
EditText log,pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        log = findViewById(R.id.textLog2);
        pas = findViewById(R.id.textPas2);
        btn = findViewById(R.id.btnReg);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.putExtra("key",log.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }
}