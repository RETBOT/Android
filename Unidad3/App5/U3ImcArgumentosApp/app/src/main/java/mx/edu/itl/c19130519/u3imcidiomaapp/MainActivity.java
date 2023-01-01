/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                       Clase Principal, en donde calculamos el imc y nos lleva al acerca de
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Roberto Esquivel Troncoso  19130519
:*  Fecha       : 04/Oct/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : En esta clase encontramos la funcionalidad principal de nuestra aplicaciom,
:*                 le permitira al usuario calcular mediante su peso y altura poder calcular
                   el imc y asi poder determinar su estado de salud
:*  Ultima modif:
:*  07/10/22       Se cambiaron las leyendas de texto y en su lugar se introjeron unas nuevas para una mejor
manipulacion de cadenas.
:*==========================================================================================
:*  //  By: RETBOT
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c19130519.u3imcidiomaapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.*;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ActivityResultCallback<ActivityResult>
{

    // Constantes para usar como argumento requestCode
    public static final int CODIGO_LEER_PESO = 2022;
    public static final int CODIGO_LEER_ESTATURA = 2020;
//  By: RETBOT
    private EditText edtPeso;
    private EditText edtEstatura;
    private ActivityResultLauncher<Intent> activityResultLaunch;


    //--------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        // obtenemos las referencias a los editText de la IU
        edtPeso = findViewById(R.id.edtPeso);
        edtEstatura = findViewById(R.id.edtEstatura);
        // Configurar el truco de ocultar teclado
        LinearLayout layoutRiz = findViewById(R.id.layoutRaiz);
        layoutRiz.setOnClickListener(new OcultarTecladoAdaptador(this));
        activityResultLaunch = registerForActivityResult(
                                new ActivityResultContracts.StartActivityForResult(), this );
    }//  By: RETBOT
    //-------------------------------------------------------------------------
    // Metodo determinar el estado usando el imc ya calculado
    public String determinarCondicion(float imc) {
        String condicion = getString(R.string.condicion_es);
        if (imc <= 15) {
            return condicion += getString(R.string.delgadez_muy_severa); //   return "Delgadez muy severa";
        }  if (imc >= 15 && imc < 16) {
            return condicion += getString(R.string.delgadez_severa); //  return "Delgadez severa";
        }  if (imc >= 16 && imc < 18.5) {
            return condicion += getString(R.string.delgadez); // return "Delgadez";
        }  if (imc >= 18.5 && imc < 25) {
            return condicion += getString(R.string.saludable_es); //  return "Peso saludable";
        }  if (imc >= 25.0 && imc < 30) {
            return condicion += getString(R.string.sobrepeso); // return "Sobrepeso";
        }  if (imc >= 30.0 && imc < 35) {
            return condicion += getString(R.string.obesidad_moderada); // return "Obesidad moderada";
        }  if (imc >= 35.0 && imc < 40) {
            return condicion += getString(R.string.delgadez_severa); //  return "Obesidad severa";
        }
    else
            return condicion += getString(R.string.obesidad_muy_severa);   // return "Obesidad muy severa (obesidad morbida)";
    }//  By: RETBOT
    //--------------------------------------------------------------------------
    // Boton para calcular el imc
    public void btnCalcularImcClick( View v )
    {
        float peso = 0f , estatura = 0f;
    try {
        peso = Float.parseFloat(edtPeso.getText().toString());
    }catch( NumberFormatException ex)
    {
        edtPeso.setError("Debe capturar un valor numerico");
        edtPeso.requestFocus();
        return;
    }
    try {
        estatura = Float.parseFloat(edtEstatura.getText().toString());
    }catch( NumberFormatException ex){
        edtEstatura.setError("Debe capturar un valor numerico");
        edtEstatura.requestFocus();
        return;
    }
     float imc = (float) (peso / Math.pow(estatura,2));
    String condicion = determinarCondicion(imc);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name))
                .setMessage(getString(R.string.imc_es)+imc+" so by that, "+condicion)
                //setMessage("Su indice de masa corporal es de : "+
                //imc+" por lo tanto eso significa que usted presenta un estado "+condicion)
                .setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
        .create()
            .show();
    }//  By: RETBOT
    //--------------------------------------------------------------------------
    // Muestra el acerca de , con toda la info del programador
    public void btnAcercaDeClick( View v)
    {
        Intent i = new Intent(MainActivity.this,AcercaDeActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("IMC").setMessage("Desea salir?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { dialogInterface.dismiss(); }
        }).create().show();
    }

    //----------------------------------------------------------------------------
    public void btnLeerEstaturaClick(View v){
    // Preparamos el Intent para el segundo Activity
        Intent intent = new Intent( this,LeerValorActivity.class );
        // Pasar el valor del peso como un float
        intent.putExtra("estatura",Float.parseFloat(edtEstatura.getText().toString()));
        intent.putExtra("codigoPeticion",CODIGO_LEER_ESTATURA);
        //startActivityForResult(intent,CODIGO_LEER_ESTATURA);
        activityResultLaunch.launch(intent);
    }//  By: RETBOT

    //-------------------------------------------------------------------------------
    public void btnLeerPesoClick(View v)
    {
        // Preparamos el Intent para el segundo Activity
        Intent intent = new Intent( this,LeerValorActivity.class );
        // Pasar el valor del peso como un float
        intent.putExtra("peso",Float.parseFloat(edtPeso.getText().toString()));
        intent.putExtra("codigoPeticion",CODIGO_LEER_PESO);
        //startActivityForResult(intent, CODIGO_LEER_PESO);
        activityResultLaunch.launch(intent);
    }

   //  By: RETBOT

    @Override
    public void onActivityResult(ActivityResult result) {
        Intent data = result.getData();
        if(result.getResultCode() == CODIGO_LEER_PESO){
            edtPeso.setText(Float.parseFloat(data.getStringExtra("valor"))+"");
            edtPeso.setFocusable(true);
        }else if( result.getResultCode() == CODIGO_LEER_ESTATURA){
            edtEstatura.setText(Float.parseFloat(data.getStringExtra("valor"))+"");
            edtEstatura.setFocusable(true);
        }
    }//  By: RETBOT
}
