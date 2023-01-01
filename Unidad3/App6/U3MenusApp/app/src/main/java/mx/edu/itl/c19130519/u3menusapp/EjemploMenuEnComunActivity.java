package mx.edu.itl.c19130519.u3menusapp;
//  By: RETBOT
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EjemploMenuEnComunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_menu_en_comun);
    }
//  By: RETBOT
    public void btnActivity2Click ( View v ) {
        Intent i = new Intent ( this, SegundoActivity.class );
        startActivity ( i );
    }

    public void btnActivity3Click ( View v ) {
        Intent i = new Intent ( this, TercerActivity.class );
        startActivity ( i );

    }//  By: RETBOT
}
