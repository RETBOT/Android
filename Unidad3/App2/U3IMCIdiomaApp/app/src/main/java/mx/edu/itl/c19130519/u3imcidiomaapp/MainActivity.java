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
//  By: RETBOT
package mx.edu.itl.c19130519.u3imcidiomaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
    }

    // Método usado para desplegar un mensaje en pantalla
    public void mostrarToast(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }

    // Método usado para calcular el IMC
    public void btnCalcularIMCClick( View v){
        String pesoS = edtPeso.getText().toString();
        String estaturaS = edtEstatura.getText().toString();
        if(!pesoS.equals("")) {
            if(!estaturaS.equals("")) {
                float peso = Float.parseFloat(pesoS);
                float estatura = Float.parseFloat(estaturaS);

                float imc = (float) (peso / Math.pow(estatura, 2));

                String condicion = determinarCondicion(imc);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.imc)
                        .setTitle(getString(R.string.titulo_app))
                        .setMessage(getString(R.string.imc_es) + imc + "\n"+condicion)
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
                mostrarToast(getString(R.string.nullEstatura));
            }
        }else{
            mostrarToast(getString(R.string.nullPeso));
        }//  By: RETBOT
    }

    // Método para retornar la condición del usuario
    public String determinarCondicion(float imc){
        if(imc>= 0 && imc < 15.0){
            return getString(R.string.delgadez_muy_severa);
        }
        if(imc >= 15 && imc <= 15.9){
            return  getString(R.string.delgadez_severa);
        }
        if(imc >= 16 && imc <= 18.4){
            return getString(R.string.delgadez);
        }//  By: RETBOT
        if(imc >= 18.5 && imc <=24.9){
            return getString(R.string.peso_saludable);
        }
        if(imc >= 25 && imc <=29.9){
            return getString(R.string.sobrepeso);
        }
        if(imc >= 30 && imc <=34.9) {
            return getString(R.string.obesidad_moderada);
        }
        if(imc >= 35 && imc <=39.9){
            return getString(R.string.obesidad_severa);
        }
        if(imc >= 40){
            return getString(R.string.obesidad_muy_severa);
        }
        return getString(R.string.error);
    }

    // Método para ir al layout Acercade
    public void btnAcercaDeClick(View v){
        Intent acercade = new Intent(this, AcercaDeActivity.class);
        startActivity(acercade);
        finish();
    }
}//  By: RETBOT
