/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                             Clase principal del juego
:*
:*  Archivo     : JuegoActivity.java
:*  Autor       : Roberto Esquivel Troncoso   19130519
:*  Fecha       : 28/11/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Clase utilizada para activar los métodos del juego
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================

:*------------------------------------------------------------------------------------------*/

//  By: RETBOT
package mx.edu.itl.c19130519.u5juegoasteroidesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class JuegoActivity extends AppCompatActivity {

    private VistaJuegoView vistaJuegoView;
    private MediaPlayer mplayAudioFondo;
    private MediaPlayer mplayAudioDisparo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_layout);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        vistaJuegoView = findViewById(R.id.vistaJuegoView);

        mplayAudioDisparo = MediaPlayer.create(this, R.raw.audio_disparo);
//  By: RETBOT
        mplayAudioFondo = MediaPlayer.create(this, R.raw.audio_fondo);
        mplayAudioFondo.setLooping(true);

        vistaJuegoView.setMplayAudioDisparo(mplayAudioDisparo);
        Toast.makeText(this, "Acerca de:\n19130519 Roberto Esquivel Troncoso", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mplayAudioFondo != null)
            mplayAudioFondo.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mplayAudioFondo != null)
            mplayAudioFondo.pause();
    }
//  By: RETBOT
    @Override
    protected void onDestroy() {
        if(mplayAudioFondo != null)
            mplayAudioFondo.stop();

        if(mplayAudioDisparo != null)
            mplayAudioDisparo.stop();

        vistaJuegoView.setCorriendo(false);
        VistaJuegoThread hilo = vistaJuegoView.getVistaJuegoThread();
//  By: RETBOT
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Log.e("Asteroides",ex.toString());
        }

        super.onDestroy();
    }
}//  By: RETBOT
