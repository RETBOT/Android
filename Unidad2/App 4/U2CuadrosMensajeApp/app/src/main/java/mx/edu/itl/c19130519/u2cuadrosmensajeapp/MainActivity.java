/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                       Cuadros de dialogo basico
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Roberto Esquivel Troncoso    19130519
:*  Fecha       : 23/09/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Despliega cuadros de dialogo utilizando TOAST SNACKBAR Y AlertDialog.Builder
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================

:*------------------------------------------------------------------------------------------*/
//  By: RETBOT

package mx.edu.itl.c19130519.u2cuadrosmensajeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //----------------------------------------------------------------------------------------------
    // TOAST de duracion corta
    public void btnToastCortaClick( View v){
        Toast.makeText(
                this,
                "Toast duracion corta",
                Toast.LENGTH_SHORT
        ).show();
    }//  By: RETBOT

    //----------------------------------------------------------------------------------------------
    // TOAST de duracion larga
    public void btnToastLargoClick( View v){
        Toast.makeText(
                this,
                "Toast duracion larga",
                Toast.LENGTH_LONG
        ).show();
    }

    //----------------------------------------------------------------------------------------------
    // SNACKBAR de duracion corta
    public void btnSnackbarClick( View v){
        // obtenemos la referencia del layout principal
        LinearLayout layoutRaiz = findViewById(R.id.layoutRaiz);
        Snackbar.make(
                layoutRaiz,
                "SnackBar Duracion corta",
                Snackbar.LENGTH_SHORT
        ).show();

    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de mensaje de simple sin botones
    public void btnAlertSimpleClick( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Cuadro de mensaje simple").create().show();
    }
//  By: RETBOT
    //----------------------------------------------------------------------------------------------
    // Cuadro de Mensaje con boton ACEPTAR
    public void btnAlertConBtnOk( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mensaje con boton Aceptar")
                .setTitle("Android")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Aceptar");
                    }
                })
                .create()
                .show();

    }

    //----------------------------------------------------------------------------------------------
    // Metodo usado para mostrar mensaje
    public void mostrarToast(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de mensaje con botones Aceptar y Cancelar
    public void btnAlertConBtnOkYCancelClick( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mensaje con boton Aceptar")
                .setTitle("Android")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Aceptar");
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        mostrarToast("Cancelado");
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }
//  By: RETBOT
    //----------------------------------------------------------------------------------------------
    // Cuadro con lista de opciones sencillas

    private CharSequence colores [] = {"Verde","Blanco","Rojo"};
    public void btnAlertConListaOpcionesClick( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escoge tu color favorito:")
                .setItems(colores,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                mostrarToast("Color seleccionado: "+colores[i]);
            }
        }).setCancelable(false)
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro con lista de opciones con botones de radio, selecion
    private int colorFavorito = 2; // por defecto rojo
    public void btnConOpcionesSeleccionUnicaClick( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escoge tu color favorito")
                .setSingleChoiceItems(colores, colorFavorito, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        colorFavorito = i; // nuevo color favorito al momento
                        mostrarToast(colores[i] + " seleccionado");
                    }
                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Nuevo color favorito " + colores[colorFavorito]);
                    }
                }).setCancelable(false)
                .create()
                .show();

    }
//  By: RETBOT
    //----------------------------------------------------------------------------------------------
    // Cuadro con lista de opciones con casillas de verificacion, seleccion multiple
    private boolean seleccionados [] ={false, false, false}; // Defaul: ninguna casilla marcada
    private ArrayList<String> coloresSeleccionados = new ArrayList<>();
    public void btnAlertConOpcionesSeleccionMultipleClick( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escoge tus colores favoritos")
                .setMultiChoiceItems(colores, seleccionados, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean marcadas) {
                        if(marcadas){ // Si se marco la casilla con palomita
                            coloresSeleccionados.add(colores[i].toString());
                            mostrarToast("Color seleccionado: "+colores[i]);
                        }else{ // Si se descmarcó la palomita
                            coloresSeleccionados.remove(colores[i].toString());
                            mostrarToast("Color deseleccionado: "+colores[i]);
                        }
                    }
                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Colores seleccionados: "+coloresSeleccionados);
                    }
                }).setCancelable(false)
                .create()
                .show();
    }
//  By: RETBOT
    //----------------------------------------------------------------------------------------------
    private EditText edtUsuario;
    private EditText edtContrasena;

    private View login_layout; // para referenciar el login

    public void btnAlertConLayoutIncrustadoClick( View v){
        // obtenemos la referencia del layout a incrustar
        login_layout = this.getLayoutInflater().inflate(R.layout.login_layout, null);
        // obtener las referencias a los campos EditText
        edtUsuario    = login_layout.findViewById(R.id.edtUsuario);
        edtContrasena = login_layout.findViewById(R.id.edtContrasena);

        // Construimos el AertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acceso")
                .setView(login_layout)
                .setPositiveButton("Entrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String usuario = edtUsuario.getText().toString();
                        String contrasena = edtContrasena.getText().toString();
                        mostrarToast("Bienvenido : "+usuario +
                                    "( "+contrasena+")");
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setCancelable(false)
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------
    public void btnAcercaDeClick( View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("19130519 Roberto Esquivel Troncoso")
                .setTitle("ITL")
                .setIcon(R.drawable.itl)
                .create()
                .show();
        
    }
//  By: RETBOT

}
