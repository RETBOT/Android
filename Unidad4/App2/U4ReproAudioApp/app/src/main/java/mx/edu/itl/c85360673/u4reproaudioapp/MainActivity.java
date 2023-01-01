package mx.edu.itl.c85360673.u4reproaudioapp;

import androidx.appcompat.app.AppCompatActivity;
//  By: RETBOT
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                        implements View.OnTouchListener {

    private Button btnFiesta;
    private MediaPlayer mp;
    private RadioButton rbDreamAboutYou;
    private RadioButton rbOjitosMentirosos;
    private RadioButton rbReinaCumbia;
    private RadioButton rbOyeMujer;
    private RadioButton rbSuavemente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiesta = findViewById ( R.id.btnFiesta );
        btnFiesta.setOnTouchListener( this );
        rbDreamAboutYou = findViewById(R.id.rbDreamAboutYou);
        rbOjitosMentirosos = findViewById(R.id.rbOjitosMentirosos);
        rbReinaCumbia = findViewById(R.id.rbReinaCumbia);
        rbOyeMujer = findViewById(R.id.rbOyeMujer);
        rbSuavemente = findViewById(R.id.rbSuavemente);

        setVolumeControlStream( AudioManager.STREAM_MUSIC );
    }//  By: RETBOT

    public void btnAcercaDeClick( View v ){
        Toast toast = Toast.makeText(this, "Roberto Esquivel Troncoso 19130519", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(view.getId() == R.id.btnFiesta){
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    reproducirAudio();
                    break;
                case MotionEvent.ACTION_UP:
                    detenerAudio();
                    break;
            }
            return true;
        }
        return false;
    }
//  By: RETBOT
    private void reproducirAudio(){https://youtu.be/WPiEbYSF9kE
        if(mp == null){
            //mp = MediaPlayer.create(this, R.raw.tropicalisimo);
            if(rbDreamAboutYou.isChecked()){
                mp = MediaPlayer.create(this, R.raw.icandreamaboutyou);
            }else if(rbOjitosMentirosos.isChecked()){
                mp = MediaPlayer.create(this, R.raw.ojitosmentirosos
                );
            }else if(rbReinaCumbia.isChecked()){
                mp = MediaPlayer.create(this, R.raw.reinadecumbias
                );
            }else if(rbOyeMujer.isChecked()){
                mp = MediaPlayer.create(this, R.raw.oyemujer
                );
            }else if(rbSuavemente.isChecked()){
                mp = MediaPlayer.create(this, R.raw.suavemente
                );
            }
            desactivarRBGrup();
            mp.start();
        }
    }//  By: RETBOT

    private void detenerAudio(){
        if(mp != null){
            mp.stop();
            mp = null;
            activarRBGrup();
        }
    }

    private  void desactivarRBGrup(){
        rbDreamAboutYou.setEnabled(false);
        rbOjitosMentirosos.setEnabled(false);
        rbReinaCumbia.setEnabled(false);
        rbOyeMujer.setEnabled(false);
        rbSuavemente.setEnabled(false);
    }

    private  void activarRBGrup(){
        rbDreamAboutYou.setEnabled(true);
        rbOjitosMentirosos.setEnabled(true);
        rbReinaCumbia.setEnabled(true);
        rbOyeMujer.setEnabled(true);
        rbSuavemente.setEnabled(true);
    }
}//  By: RETBOT
