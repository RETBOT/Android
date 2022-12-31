/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                    Clase que despliega la bandera de México (Color blanco y logo)
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Roberto Esquivel Troncoso     19130519
:*  Fecha       : 18/09/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Este Activity despliega la bandera de Mexico fromada
                  con LinearLayout´s y muestra el escudo de la bandera
                  desde un recurso drawable, en un solo Layout.

:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c19130519.u2banderita3lay1actapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    //----------------------------------------------------------------------------------------------
    // Metodo para cerrar la app
    public void btnSalir (View V){ finish(); }
    //----------------------------------------------------------------------------------------------
    // Metodo para desplegar información
    public void btnAcercaDe( View v){
        Toast.makeText(
                this,
                "19130519 Roberto Esquivel Troncoso",
                Toast.LENGTH_SHORT
        ).show();
    }
    //----------------------------------------------------------------------------------------------
    //Metodo abrir una nueva vista
    public void btnBlancoClick( View v){
        Intent blanco = new Intent(this, MainActivity.class);
        startActivity(blanco);
        finish();
    }
    //----------------------------------------------------------------------------------------------
    //Metodo abrir una nueva vista
    public void btnVerdeClick( View v){
        Intent verde = new Intent(this, MainActivity.class);
        startActivity(verde);
        finish();
    }
}