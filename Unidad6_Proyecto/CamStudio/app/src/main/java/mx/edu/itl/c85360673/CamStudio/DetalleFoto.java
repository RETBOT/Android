package mx.edu.itl.c85360673.CamStudio;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

public class DetalleFoto extends AppCompatActivity {
    private ImageView imgvDetalleFoto;
    private String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_foto);
        getSupportActionBar().hide();

        imgvDetalleFoto = findViewById(R.id.imgvDetalleFoto);
        path = Environment.getExternalStorageDirectory().toString() + "/DCIM/";

        String foto = getIntent().getStringExtra("Foto");
        String carpeta = getIntent().getStringExtra("Carpeta");
        imgvDetalleFoto.setScaleType(ImageView.ScaleType.FIT_XY);
        String strUri = path + carpeta+"/"+foto;
        imgvDetalleFoto.setImageURI(Uri.parse(strUri));
    }
}