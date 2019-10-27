package com.example.haiqa.playlistmusic;

import android.app.Activity;
import android.media.MediaMetadata;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

import co.mobiwise.library.InteractivePlayerView;
import co.mobiwise.library.OnActionClickedListener;

public class MainActivity extends AppCompatActivity implements OnActionClickedListener , AdapterView.OnItemClickListener {

    private InteractivePlayerView ipv;
    private ImageView control;
    private MediaPlayer mediaPlayer;
    private ImageView btnNext;

    private ListView listView;
    private String[] number;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = mediaPlayer.create(MainActivity.this, R.raw.romancenostart);

        number = getResources().getStringArray(R.array.listmusic);
        listView = (ListView) findViewById(R.id.listMusic);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, number);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        // call a song
        uri = Uri.parse("android.resource://com.example.haiqa.playlistmusic//raw//romancenostart");
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(MainActivity.this, uri);

        String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        int milli = Integer.parseInt(durationString);
        milli = milli/1000;

        ipv = (InteractivePlayerView) findViewById(R.id.ipv);
        ipv.setMax(300);
        ipv.setProgress(0);
        ipv.setOnActionClickedListener(this);

        control = (ImageView) findViewById(R.id.control);
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ipv.isPlaying()){
                    ipv.start();
                    control.setBackgroundResource(R.drawable.pause);

                    mediaPlayer.start();
                }
                else{
                    ipv.stop();
                    control.setBackgroundResource(R.drawable.play);

                    mediaPlayer.pause();
                }
            }
        });
    }

    @Override
    public void onActionClicked(int id){
        switch(id){
            case 1:
                Toast.makeText(MainActivity.this, "Pilihan Shuffled", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "Pilihan Love", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "Pilihan Repeat", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        TextView textView = (TextView) view;
        String parameterNilai = String.valueOf(textView.getText());

        if(parameterNilai.equals("Romance no Start")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.haiqa.playlistmusic//raw//romancenostart");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.romancenostart);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();

        }else if(parameterNilai.equals("Synchronicity")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.haiqa.playlistmusic//raw//synchronicity");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.synchronicity);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();

        }else if(parameterNilai.equals("Romantic Ikayaki")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.haiqa.playlistmusic//raw//romanticikayaki");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.romanticikayaki);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        } else if(parameterNilai.equals("Yubibouenkyo")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.haiqa.playlistmusic//raw//yubibouenkyou");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.yubibouenkyou);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        } else if(parameterNilai.equals("Ima Hanashitai Dareka ga Iru")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.haiqa.playlistmusic//raw//imahanashitaidarekagairu");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.imahanashitaidarekagairu);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        } else {
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.haiqa.playlistmusic//raw//romancenostart");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.romancenostart);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }
    }

    private void cekMusikEnd(){
        if(ipv.isPlaying()){
            ipv.start();
            control.setBackgroundResource(R.drawable.pause);

            mediaPlayer.start();
        }
    }

    private void cekMusikPlay(){
        ipv.stop();
        control.setBackgroundResource(R.drawable.play);

        mediaPlayer.pause();
    }
}
