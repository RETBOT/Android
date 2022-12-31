/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                       Primera pantalla de carga
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Roberto Esquivel Troncoso  19130519
:*  Fecha       : 04/Oct/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : En esta clase plasmamos una pantalla de presentacion antes de que se lleve al
                usuario al apartado en donde se encuentra nuestra funcionalidad principal.
:*
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c19130519.u3imcidiomaapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    //--------------------------------------------------------------------------
    // On create para hacer el cambio al main activity luego de 2 segs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        // Hacer el cambio al MainActivity despues de 2 segs.
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity( intent );
            finish();
        }
    },2000);
    }

}