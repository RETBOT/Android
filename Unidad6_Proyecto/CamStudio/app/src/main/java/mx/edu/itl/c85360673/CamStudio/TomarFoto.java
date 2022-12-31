/*:
 *: Requiere: <uses-permission android:name="android.permission.CAMERA"/>
 *:           <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 *:           <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
 *:
 *: Requiere agregar lo siguiente en el AndroidManifest.xml:
 *:
 *:        <provider
 *:             android:name="androidx.core.content.FileProvider"
 *:             android:authorities="mx.edu.itl.c85360673.CamStudio.provider"
 *:             android:exported="false"
 *:             android:grantUriPermissions="true">
 *:             <!-- ressource file to create -->
 *:             <meta-data
 *:                 android:name="android.support.FILE_PROVIDER_PATHS"
 *:                 android:resource="@xml/file_paths">
 *:             </meta-data>
 *:        </provider>
 *:
 *: Requiere crear el archivo  file_paths.xml  en la carpeta de recursos xml :
 *:
 *:          <?xml version="1.0" encoding="utf-8"?>
 *:          <paths xmlns:android="http://schemas.android.com/apk/res/android">
 *:                <external-path name="external_files" path="." />
 *:          </paths>
 *:
 */


package mx.edu.itl.c85360673.CamStudio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import mx.edu.itl.c19130519.androlib.util.permisos.ChecadorDePermisos;
import mx.edu.itl.c19130519.androlib.util.permisos.PermisoApp;

public class TomarFoto extends AppCompatActivity {

    private Uri uriFoto;
    public static final  int CODIGO_CAPTURA_FOTO = 123;

    private ImageView imgvFotoCaptura;
    private String archFoto;
    private Intent intentOrigen; // Intent que invoco a este activity
    private String carpeta;

    private PermisoApp [] permisosReq = {
            new PermisoApp  ( Manifest.permission.CAMERA, "Camara", true  ),
            new PermisoApp  ( Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true  ),
            new PermisoApp  ( Manifest.permission.WRITE_EXTERNAL_STORAGE, "Almacenamiento", true )
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomarfoto);

        ChecadorDePermisos.checarPermisos ( this, permisosReq );

        imgvFotoCaptura = findViewById(R.id.imgvFotoCaptura);

        intentOrigen = getIntent();
        carpeta = intentOrigen.getStringExtra("carpeta");
    }

    public void btnCapturaSimpleClick ( View v ) {
        // formar el nombre del archivo basado en la checa y hora para que sea nombre unico
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strFechaHora = simpleDateFormat.format(new Date());
        archFoto = carpeta + "_" + strFechaHora + ".jpg";

        //
        File fileFoto = new File (Environment.getExternalStorageDirectory().getAbsolutePath() +
                File.separator +
                "DCIM" +
                File.separator +
                carpeta +
                File.separator +
                archFoto );

        // Creamos el URI correspondiente al archivo de destino de la foto se usa
        // FileProvider para respetar las politicas de seguridad
        uriFoto = FileProvider.getUriForFile(
                this,
                BuildConfig.APPLICATION_ID + ".provider",
                fileFoto
        );// Uri.fromFile( fileFoto );

        // Creamos el inent que llama a la app de la camara de fotos y le pasamos el uri del archivo
        // donde se debera guardar la foto si es que se captura una
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto);
        startActivityForResult(intent, CODIGO_CAPTURA_FOTO);
    }

    public void verFotosClick(View v) {
        // Preparamos el Intent para el segundo Activity
        Intent intent = new Intent( this,verFotos.class );
        // Pasar el valor del peso como un float
        intent.putExtra("carpeta",carpeta);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODIGO_CAPTURA_FOTO) {
            if( resultCode == RESULT_OK ){
                // Abrir el activity para mostrar la foto en pantalla completa.
                // se envia como argumento el URI de la foto como un string
                //Intent intent = new Intent (this, MuestraFotoActivity.class);
                //intent.putExtra("uri", uriFoto.toString());
                //startActivity(intent);
                imgvFotoCaptura.setScaleType(ImageView.ScaleType.FIT_XY);
                String path = Environment.getExternalStorageDirectory().toString() + "/DCIM/" + carpeta + "/";
                String strUri = path+archFoto;
                imgvFotoCaptura.setImageURI(Uri.parse(strUri));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult ( requestCode, permissions, grantResults );
        if ( requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS ) {
            ChecadorDePermisos.verificarPermisosSolicitados ( this, permisosReq, permissions, grantResults );
        }
    }
}
