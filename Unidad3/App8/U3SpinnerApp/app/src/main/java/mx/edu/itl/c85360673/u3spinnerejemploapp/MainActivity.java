package mx.edu.itl.c85360673.u3spinnerejemploapp;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//  By: RETBOT
    public void btnSpinnerSimpleClick ( View v ) {
        Intent intent = new Intent( this, SpinnerSimpleActivity.class );
        startActivity ( intent );
    }

    public void btnSpinnerPersonalizadoClick ( View v ) {
        Intent intent = new Intent( this, SpinnerPersonalizadoActivity.class );
        startActivity ( intent );
    }//  By: RETBOT

    public void btnAcercaDe( View v ){
        Intent intent  = new Intent ( this, AcercaDe.class );
        startActivity ( intent );
        finish();
    }
}//  By: RETBOT
