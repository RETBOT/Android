package mx.edu.itl.c85360673.CamStudio;
//  By: RETBOT
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class AcercaDe extends AppCompatActivity {

    private VideoView videoView;
    private String ruta;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Reproduccion");
        progressDialog.setMessage("Cargando...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
//  By: RETBOT
        videoView = findViewById(R.id.videoView);
        ruta = getIntent().getStringExtra("rutaVideo");

        videoView.setVideoURI(Uri.parse(ruta));
        videoView.setMediaController(new MediaController(this));

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(false);
                videoView.requestFocus();
                progressDialog.dismiss();
                videoView.start();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
//  By: RETBOT
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                finish();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position",videoView.getCurrentPosition());
        videoView.pause();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int position = savedInstanceState.getInt("position");
        videoView.seekTo(position);
    }
}//  By: RETBOT
