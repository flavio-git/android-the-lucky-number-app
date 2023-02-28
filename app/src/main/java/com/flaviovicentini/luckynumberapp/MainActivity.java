package com.flaviovicentini.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.activity_main_et_user_name);
        button = findViewById(R.id.activity_main_btn_sign_in);

        settingButton();
    }

    private void settingButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editText.getText().toString();
                int luckyNumber = generateLuckyNumber();

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtra("user name", userName);
                i.putExtra("lucky number", luckyNumber);
                startActivity(i);
            }
        });
    }

    private int generateLuckyNumber() {
        return new Random().nextInt(101);
    }

}