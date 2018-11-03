package wallyson.lima.mediaplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.justin_timberlake);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    // stop and give option to start again
                    pauseMusic();
                } else {
                    startMusic();
                }
            }
        });
    }

    public void pauseMusic() {
        if( mediaPlayer != null ) {
            mediaPlayer.pause();
            playButton.setText("Play");
        }
    }

    public void startMusic() {
        if (mediaPlayer != null ) {
            mediaPlayer.start();
            playButton.setText("Pause");
        }
    }
}
