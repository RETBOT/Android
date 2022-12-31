/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                    Clase que despliega la bandera de México en una única pantalla
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Roberto Esquivel Troncoso     19130519
:*  Fecha       : 12/09/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Este Activity despliega la bandera de Mexico fromada
                  con LinearLayout´s y muestra el escudo de la bandera
                  desde un recurso drawable, en un solo Layout.

:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c19130519.u2banderita1lay1actapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // ---------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //----------------------------------------------------------------------------------------------
    // Metodo para cerrar la app
    public void btnSalirClick( View v ){
        finish();
    }
}