package mx.edu.itl.c85360673.u4smsenvioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtTelefonoDestino;
    private EditText edtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTelefonoDestino = findViewById ( R.id.edtTelefonoDestino );
        edtMensaje         = findViewById ( R.id.edtMensaje         );
    }

    public void btnEnviarClick ( View v ) {
    }

    private boolean validarDatos () {
        return true;
    }

}
