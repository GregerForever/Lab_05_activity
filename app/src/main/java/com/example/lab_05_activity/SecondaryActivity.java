package com.example.lab_05_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    EditText secTxt;
    TextView label2;
    Switch switch1;
    Switch switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        secTxt = findViewById(R.id.SecondaryEdit);
        label2 = findViewById(R.id.displayTextSecondary);
        switch1 = findViewById(R.id.Switch1);
        switch2 = findViewById(R.id.Switch2);

        Intent trns = getIntent();
        String sl = trns.getStringExtra("main");
        switch1.setChecked(trns.getBooleanExtra("s1", false));
        switch2.setChecked(trns.getBooleanExtra("s2", false));
        label2.setText(sl);

    }

    public void onOk(View v)
    {
        Intent i = new Intent();
        String s = secTxt.getText().toString();
        i.putExtra("sec", s);
        i.putExtra("sA1", switch1.isChecked());
        i.putExtra("sA2", switch2.isChecked());
        setResult(RESULT_OK, i);
        finish();
    }

    public void onCancel(View v)
    {
        finish();
    }
}