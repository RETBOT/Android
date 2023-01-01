package mx.edu.itl.c19130519.u3imcidiomaapp;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
//  By: RETBOT
public class LeerValorActivity extends AppCompatActivity {
    public static final int ARG_NO_DEFINIDO = -1;
//  By: RETBOT

    private EditText edtValor;
    private Intent intentOrigen; // Intent que invoco a este activity
    private float valor;
    public int codigoPeticion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_valor);

        edtValor = findViewById(R.id.edtValor);
        // Recuperamos el valor del argumento recibido ( peso o estatura )
        intentOrigen = getIntent();
        valor = intentOrigen.getFloatExtra("peso",ARG_NO_DEFINIDO);
        codigoPeticion = intentOrigen.getIntExtra("codigoPeticion",ARG_NO_DEFINIDO);
        if( valor == ARG_NO_DEFINIDO) {
            valor = intentOrigen.getFloatExtra("estatura", 0f);
            codigoPeticion = intentOrigen.getIntExtra("codigoPeticion", 0);
        }//  By: RETBOT
        // Establecemos el valor del argumento en el EditText
        edtValor.setText(String.valueOf(valor));
    }
    //----------------------------------------------------------------------------------------------
    public void btnCancelarClick (View v){
        setResult( RESULT_CANCELED );
        finish();
    }
    //----------------------------------------------------------------------------------------------
    public void btnAceptarClick(View v){
        intentOrigen.putExtra("valor", edtValor.getText().toString());
        setResult(codigoPeticion, intentOrigen);
        finish();
    }
}//  By: RETBOT
