package mx.edu.itl.c85360673.u4smsenvioapp;
//  By: RETBOT
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

import util.permisos.ChecadorDePermisos;
import util.permisos.PermisoApp;

public class MainActivity extends AppCompatActivity {
    private EditText      edtTelefonoDestino;
    private EditText      edtMensaje;

    private PermisoApp[] permisosReq = new PermisoApp [] {
            new PermisoApp(Manifest.permission.SEND_SMS, "SMS", true),
            new PermisoApp(Manifest.permission.CALL_PHONE, "Telefono", true),
            new PermisoApp(Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true),
    };
//  By: RETBOT
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
//  By: RETBOT
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
//  By: RETBOT
    //----------------------------------------------------------------------------------------------
}
