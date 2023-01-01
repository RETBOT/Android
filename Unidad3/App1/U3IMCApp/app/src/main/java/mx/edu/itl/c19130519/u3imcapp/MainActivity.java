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

:*------------------------------------------------------------------------------------------*/


package mx.edu.itl.c19130519.u3imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
//  By: RETBOT
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables globales
    private EditText edtPeso;
    private EditText edtEstatura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        // Obtenemos las referencias a los editText de la UI
        edtPeso = findViewById(R.id.edtPeso);
        edtEstatura = findViewById(R.id.edtEstatura);
    }
//  By: RETBOT
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
                        .setTitle("IMC")
                        .setMessage(condicion)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mostrarToast("Aceptar");
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
            }else{
                mostrarToast("Ingresa una Estatura (m)");
            }
        }else{
            mostrarToast("Ingresa un Peso (Kg)");
        }
    }
//  By: RETBOT
    // Método para retornar la condición del usuario
    public String determinarCondicion(float imc){
        if(imc>= 0 && imc < 15.0){
            return "Delgadez muy severa";
        }
        if(imc >= 15 && imc <= 15.9){
            return "Delgadez severa";
        }
        if(imc >= 16 && imc <= 18.4){
            return "Delgadez";
        }
        if(imc >= 18.5 && imc <=24.9){
            return "Peso Saludable";
        }
        if(imc >= 25 && imc <=29.9){
            return "Sobrepeso";
        }
        if(imc >= 30 && imc <=34.9) {
            return "Obesidad Moderada";
        }
        if(imc >= 35 && imc <=39.9){
            return "Obesidad severa";
        }
        if(imc >= 40){
            return"Obesidad muy severa (obesidad mórvida)";
        }
        return "error";
    }

    // Método para ir al layout Acercade
    public void btnAcercaDeClick(View v){
        Intent acercade = new Intent(this, AcercaDeActivity.class);
        startActivity(acercade);
        finish();
    }
}//  By: RETBOT
