package com.example.frenchteacherapp;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button blackBtn, yellowBtn, redBtn, purpleBtn, greenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        blackBtn = findViewById(R.id.blackBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        redBtn = findViewById(R.id.redBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        greenBtn = findViewById(R.id.greenBtn);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            redBtn.setOnClickListener(this);
            yellowBtn.setOnClickListener(this);
            blackBtn.setOnClickListener(this);
            greenBtn.setOnClickListener(this);
            purpleBtn.setOnClickListener(this);


            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        // find the button by ID and play the correct sound

        int clickedBtnId = v.getId();

            if(clickedBtnId == R.id.redBtn){
                Object PlaySounds;
            PlaySounds(R.raw.red);

        } else if(clickedBtnId == R.id.blackBtn){
            Object PlaySounds;
            PlaySounds(R.raw.black);

        } else if(clickedBtnId == R.id.greenBtn){
            Object PlaySounds;
            PlaySounds(R.raw.green);

        } else if(clickedBtnId == R.id.purpleBtn){
            Object PlaySounds;
            PlaySounds(R.raw.purple);

        } else if(clickedBtnId == R.id.yellowBtn){
            Object PlaySounds;
            PlaySounds(R.raw.yellow);
        }


    }
    public void PlaySounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }
}