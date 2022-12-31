/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                              Envió de mensajes SMS
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Roberto Esquivel Troncoso    19130519
:*  Fecha       : 22/11/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Envió de mensajes SMS integrando librerías
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c85360673.u4smsenvioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import mx.edu.itl.c19130519.androlib.util.permisos.ChecadorDePermisos;
import mx.edu.itl.c19130519.androlib.util.permisos.PermisoApp;

public class MainActivity extends AppCompatActivity {
    private EditText      edtTelefonoDestino;
    private EditText      edtMensaje;

    private PermisoApp[] permisosReq = new PermisoApp [] {
            new PermisoApp(Manifest.permission.SEND_SMS, "SMS", true),
            new PermisoApp(Manifest.permission.CALL_PHONE, "Telefono", true),
            new PermisoApp(Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true),
    };

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTelefonoDestino = findViewById(R.id.edtTelefonoDestino);
        edtMensaje = findViewById(R.id.edtMensaje);
        ChecadorDePermisos.checarPermisos(this, permisosReq);
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS){
            ChecadorDePermisos.verificarPermisosSolicitados(this, permisosReq, permissions, grantResults);

        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnVerPermisosClick ( View v ) {
        String permisos = "";
        for(int i = 0; i < permisosReq.length; i++){
            permisos += " Permisos "+(i+1)+".-"+permisosReq[i].getNombreCorto() +
                    "- Activo:" + permisosReq[i].isOtorgado()+"\n";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permisos")
                .setMessage(permisos)
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------

    public void btnEnviarClick (View v ) {
        if ( validarDatos () == false )
            return;

        SmsManager smsMgr = SmsManager.getDefault();
        smsMgr.sendTextMessage (
                edtTelefonoDestino.getText().toString(),
                null,
                edtMensaje.getText().toString(),
                null,
                null
        );

        Toast.makeText (this, "SMS enviado",
                         Toast.LENGTH_SHORT ).show();
        edtMensaje.setText ( "" );
    }

    //----------------------------------------------------------------------------------------------

    private boolean validarDatos () {
        if ( edtTelefonoDestino.getText().toString().isEmpty() ) {
            edtTelefonoDestino.setError ( "Telefono no puede ser vacio" );
            return false;
        }

        if ( edtMensaje.getText().toString().isEmpty() ) {
            edtMensaje.setError ( "Proporcione un mensaje a enviar" );
            return false;
        }
        return true;
    }

    //----------------------------------------------------------------------------------------------
    public void btnAcercaDeClick( View v ){
        Toast toast = Toast.makeText(this, "Roberto Esquivel Troncoso 19130519", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    //----------------------------------------------------------------------------------------------
}
