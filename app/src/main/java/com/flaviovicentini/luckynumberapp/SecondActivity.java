package com.flaviovicentini.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    String userName;
    int luckyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.activity_second_tv_user_lucky_number);
        button = findViewById(R.id.activity_second_btn_share_lucky_number);

        Intent intent = getIntent();

        userName = intent.getStringExtra("user name");
        luckyNumber = intent.getIntExtra("lucky number", 0);

        textView.setText(String.valueOf(luckyNumber));

        settingButton();
    }

    private void settingButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = userName + " lucky number";
                String message = "Hey there! I'm sharing my lucky number and it's : " + luckyNumber;
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(intent, "Choose a platform"));
            }
        });
    }

}