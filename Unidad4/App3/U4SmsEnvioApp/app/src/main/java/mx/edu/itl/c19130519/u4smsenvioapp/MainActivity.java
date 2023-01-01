package mx.edu.itl.c19130519.u4smsenvioapp;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//  By: RETBOT
public class MainActivity extends AppCompatActivity {
    private EditText edtTelefonoDesino;
    private EditText edtMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTelefonoDesino = findViewById(R.id.edtTelefonoDesino);
        edtMensaje = findViewById(R.id.edtMensaje);
    }

    public void btnEnviarClick ( View v ){
        if(validarDatos() == false )
            return;

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(
                edtTelefonoDesino.getText().toString(),
                null,
                edtMensaje.getText().toString(),
                null,
                null
        );
        Toast.makeText(this, "SMS enviado",
                        Toast.LENGTH_SHORT).show();
        edtMensaje.setText("");
//  By: RETBOT
    }

    private boolean validarDatos() {
        if( edtTelefonoDesino.getText().toString().isEmpty() ) {
            edtTelefonoDesino.setError("Telefono no pede ser vacio");
            return false;
        }
        if( edtMensaje.getText().toString().isEmpty() ) {
            edtMensaje.setError("Proporciona un mensaje a enviar");
            return false;
        }
        return true;
    }

    public void btnAcercaDeClick( View v ){
        Toast toast = Toast.makeText(this, "Roberto Esquivel Troncoso 19130519", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}//  By: RETBOT
