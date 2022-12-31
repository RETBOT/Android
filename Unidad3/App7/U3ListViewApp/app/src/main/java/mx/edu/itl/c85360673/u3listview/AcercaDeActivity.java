package mx.edu.itl.c85360673.u3listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
    }

    public void btnInicio(View v){
        Intent intent  = new Intent ( this, MainActivity.class );
        startActivity ( intent );
        finish();
    }
}