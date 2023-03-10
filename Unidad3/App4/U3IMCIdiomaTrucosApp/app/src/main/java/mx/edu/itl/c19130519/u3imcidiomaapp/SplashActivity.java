/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                       Inicio de la aplicacion
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Roberto Esquivel Troncoso     19130519
:*  Fecha       : 04/10/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Pantalla de bienvenida de la aplicacion IMC
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

//  By: RETBOT
package mx.edu.itl.c19130519.u3imcidiomaapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import u3imcidiomaapp.R;

public class SplashActivity extends AppCompatActivity {
//  By: RETBOT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        // Hacer el cambio a MainAactivity despues de 2 seg
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }//  By: RETBOT
}
