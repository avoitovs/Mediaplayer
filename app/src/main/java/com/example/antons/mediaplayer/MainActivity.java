package com.example.antons.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    MediaPlayer player;
    Button stop;
    Button pause;
    Button play;

  //  TextView info = findViewById(R.id.songInfo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         play = findViewById(R.id.play);
         stop = findViewById(R.id.stop);
         pause = findViewById(R.id.pause);
        ImageView coverImage = findViewById(R.id.cover);

        coverImage.setImageResource(R.drawable.cover);

        stop.setEnabled(false);
        pause.setEnabled(false);


        player = MediaPlayer.create(this,R.raw.song);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Playing song",Toast.LENGTH_SHORT).show();
                player.start();
                stop.setEnabled(true);
                pause.setEnabled(true);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Stopping song",Toast.LENGTH_SHORT).show();
                player.stop();
                try {
                preparePlayerToStart();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Song paused",Toast.LENGTH_SHORT).show();
                player.pause();
            }
        });





    }

    private void preparePlayerToStart() throws IOException{
        player.prepare();
    }
}
