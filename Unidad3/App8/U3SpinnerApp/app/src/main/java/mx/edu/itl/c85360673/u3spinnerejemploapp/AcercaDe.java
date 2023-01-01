package mx.edu.itl.c85360673.u3spinnerejemploapp;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//  By: RETBOT
public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
    }
    public void btnInicio(View v){
        Intent intent  = new Intent ( this, MainActivity.class );
        startActivity ( intent );
        finish();
    }
}//  By: RETBOT
