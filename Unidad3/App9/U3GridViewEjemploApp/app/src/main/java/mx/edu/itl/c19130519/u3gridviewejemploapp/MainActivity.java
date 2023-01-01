package mx.edu.itl.c19130519.u3gridviewejemploapp;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
//  By: RETBOT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//  By: RETBOT
    public void btnGridViewImagenesClick (View v){
        Intent intent = new Intent( this, GridViewActivity.class );
        startActivity ( intent );
    }
    public void btnAcercaDe( View v ){
        Intent intent  = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
        finish();
    }
}//  By: RETBOT
