/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                    Clase que despliega la bandera de México
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

package mx.edu.itl.c19130519.u2banderita1lay1actapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(
                this,
                "Bandera 1 (onCreate)",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(
                this,
                "Bandera 1 (onSrart)",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(
                this,
                "Bandera 1 (onResume)",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(
                this,
                "Bandera 1 (onPause)",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(
                this,
                "Bandera 1 (onStop)",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(
                this,
                "Bandera 1 (onDestroy)",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Toast.makeText(
                this,
                "Bandera 1 (onRestart)",
                Toast.LENGTH_SHORT
        ).show();
    }

    // Metodo para cerrar la app
    public void btnSalirClick( View v ){
        finish();
    }
    //Metodo abrir una nueva vista
    public void btnUsaClick( View v){
        Intent banUsa = new Intent(this, BanderaUSA.class);
        startActivity(banUsa);
        finish();
    }
    public void btnCanadaClick( View v ){
        Intent banCA = new Intent(this, banderacanada.class);
        startActivity(banCA);
        finish();
    }

    public void btnAcercaDe( View v){
        Toast.makeText(
                this,
                "19130519 Roberto Esquivel Troncoso",
                Toast.LENGTH_LONG
        ).show();
    }


}