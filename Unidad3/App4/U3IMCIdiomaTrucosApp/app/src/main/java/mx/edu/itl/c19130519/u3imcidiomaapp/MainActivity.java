/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                       Menú Principal del IMCApp
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Roberto Esquivel Troncoso     19130519
:*  Fecha       : 04/10/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Clase principal para el cálculo del IMC, con el peso y la altura
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/


package mx.edu.itl.c19130519.u3imcidiomaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
//  By: RETBOT
import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import u3imcidiomaapp.R;

public class MainActivity extends AppCompatActivity {

    // Variables globales
    private EditText edtPeso;
    private EditText edtEstatura;
//  By: RETBOT

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        // Obtenemos las referencias a los editText de la UI
        edtPeso = findViewById(R.id.edtPeso);
        edtEstatura = findViewById(R.id.edtEstatura);

        // Configurar el truco de ocultar teclado
        LinearLayout layoutRaiz = findViewById(R.id.layoutRaiz);
        layoutRaiz.setOnClickListener( new OcultarTecladoAdaptador(this) );
    }

    // Método usado para desplegar un mensaje en pantalla
    public void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    // ---------------------------------------------------------------------------------------------
    // Método usado para calcular el IMC
    public void btnCalcularIMCClick(View v) {
        float peso = 0;
        float estatura = 0;
            try {
                peso = Float.parseFloat(edtPeso.getText().toString());
            } catch (NumberFormatException ex) {
                edtPeso.setError("Debe capturar un valor numerico");
                edtPeso.requestFocus();
            }

            try {
                 estatura = Float.parseFloat(edtEstatura.getText().toString());
            } catch (NumberFormatException ex) {
                 edtEstatura.setError("Debe capturar un valor numerico");
                 edtEstatura.requestFocus();
            }

            float imc = (float) (peso / Math.pow(estatura, 2));

            if(imc>0) {
                String condicion = determinarCondicion(imc);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.imc)
                        .setTitle(getString(R.string.titulo_app))
                        .setMessage(getString(R.string.imc_es) + imc + "\n" + condicion)
                        .setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
            }else{
                mostrarToast("Valores incorrectos");
            }
    }

    // ---------------------------------------------------------------------------------------------
    // Método para retornar la condición del usuario
    public String determinarCondicion(float imc) {
        if (imc >= 0 && imc < 15.0) {
            return getString(R.string.delgadez_muy_severa);
        }
        if (imc >= 15 && imc <= 15.9) {
            return getString(R.string.delgadez_severa);
        }//  By: RETBOT
        if (imc >= 16 && imc <= 18.4) {
            return getString(R.string.delgadez);
        }
        if (imc >= 18.5 && imc <= 24.9) {
            return getString(R.string.peso_saludable);
        }
        if (imc >= 25 && imc <= 29.9) {
            return getString(R.string.sobrepeso);
        }
        if (imc >= 30 && imc <= 34.9) {
            return getString(R.string.obesidad_moderada);
        }
        if (imc >= 35 && imc <= 39.9) {
            return getString(R.string.obesidad_severa);
        }
        if (imc >= 40) {
            return getString(R.string.obesidad_muy_severa);
        }
        return getString(R.string.error);
    }

    // ---------------------------------------------------------------------------------------------
    // Método para ir al layout Acercade
    public void btnAcercaDeClick(View v) {
        Intent acercade = new Intent(this, AcercaDeActivity.class);
        startActivity(acercade);
        finish();
    }
//  By: RETBOT
    // ---------------------------------------------------------------------------------------------
    // Anular la acción del boton "Atras" Del Celular
    @Override
    public void onBackPressed() {
        // super.onBackPressed(); // No hace nada
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("IMC")
                .setMessage("Desea salir : ")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }
//  By: RETBOT
    // ---------------------------------------------------------------------------------------------
}
