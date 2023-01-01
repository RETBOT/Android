/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                       Información de la aplicación
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Roberto Esquivel Troncoso     19130519
:*  Fecha       : 04/10/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Despliegue de la información del creador de la aplicación
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
import android.view.View;
import u3imcidiomaapp.R;

public class AcercaDeActivity extends AppCompatActivity {
//  By: RETBOT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade_layout);
    }
    // Método para regresar al inicio
    public void btnInicioClick(View v){
        Intent inicio = new Intent(this, SplashActivity.class);
        startActivity(inicio);
        finish();
    }//  By: RETBOT

}
