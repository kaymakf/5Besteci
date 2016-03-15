package com.furkan.studyjam.besbesteci;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private String pieceName;
    private TextView nowPlaying;
    private Button listenButton;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView ComposerPicture = (ImageView) findViewById(R.id.composer_picture);
        TextView textView = (TextView) findViewById(R.id.text_view);
        nowPlaying = (TextView) findViewById(R.id.now_playing);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String detail = intent.getStringExtra("detail");
        int imageId = intent.getIntExtra("imageId", 0);
        int audioId = intent.getIntExtra("audioId", 0);
        pieceName = "Şu an Çalıyor: " + intent.getStringExtra("pieceName");

        setTitle(title);
        textView.setText(detail);
        ComposerPicture.setImageResource(imageId);

        listenButton = (Button) this.findViewById(R.id.listen_button);
        mp = MediaPlayer.create(this, audioId);
        listenButton.setOnClickListener(this);
    }

    @Override
    protected void onStop(){
        super.onStop();
        mp.stop();
    }

    @Override
    public void onClick(View v) {
        if(mp.isPlaying()) {
            mp.pause();
            listenButton.setText("Dinle");
            nowPlaying.setText("");
        }
        else {
            mp.start();
            listenButton.setText("Duraklat");
            nowPlaying.setText(pieceName);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}