package com.example.antons.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button play = findViewById(R.id.play);
        Button stop = findViewById(R.id.stop);

        player = MediaPlayer.create(this,R.raw.song);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Playing song",Toast.LENGTH_LONG).show();
                player.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Stopping song",Toast.LENGTH_LONG).show();
                player.stop();
                try {
                pre();} catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

    }

    private void pre () throws IOException{
        player.prepare();
    }
}
