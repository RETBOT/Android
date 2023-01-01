package mx.edu.itl.c85360673.u4tomarfotosapp;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
//  By: RETBOT
public class MuestraFotoActivity extends AppCompatActivity {

    private ImageView imgvFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_foto);

        imgvFoto = findViewById(R.id.imgvFoto);
        // Ocultar la barra de acciones
        this.getSupportActionBar().hide();
//  By: RETBOT
        // obtenemos la ubicacion de la foto desde el parametro que viene en los Extras
        String strUri = getIntent().getStringExtra("uri");
        imgvFoto.setImageURI(Uri.parse(strUri));
    }
}
//  By: RETBOT
