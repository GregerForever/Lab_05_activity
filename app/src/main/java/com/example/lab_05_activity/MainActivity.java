package com.example.lab_05_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context activity = this;

    EditText mainTxt;
    TextView label;
    CheckBox check1;
    CheckBox check2;

    public Dialog onCreateDialog() {

        //Context act = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        return builder
                .setTitle("Выход")
                .setIcon(R.drawable.logout)
                .setMessage("Вы хотите выйти из приложения?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        return;
                    }
                })
                .create();
    }

    protected void onActivityResult(int reqCode, int resCode, @Nullable Intent data)
    {
        if (reqCode == 133)
        {
            if (data != null)
            {
                String sl = data.getStringExtra("sec");
                check1.setChecked(data.getBooleanExtra("sA1", false));
                check2.setChecked(data.getBooleanExtra("sA2", false));
                Toast.makeText(this, sl, Toast.LENGTH_SHORT).show();
                label.setText(sl);
            }
        }
        super.onActivityResult(reqCode, resCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTxt = findViewById(R.id.MainEdit);
        label = findViewById(R.id.DisplayText);
        check1 = findViewById(R.id.Check1);
        check2 = findViewById(R.id.Check2);
    }

    public void onOpen(View v)
    {
        String text = mainTxt.getText().toString();
        Intent transfer = new Intent(this, SecondaryActivity.class);
        transfer.putExtra("main", text);
        transfer.putExtra("s1", check1.isChecked());
        transfer.putExtra("s2", check2.isChecked());

        startActivityForResult(transfer, 133);
    }

    public void onExit(View v)
    {
        Dialog dialog = onCreateDialog();
        dialog.show();
    }
}