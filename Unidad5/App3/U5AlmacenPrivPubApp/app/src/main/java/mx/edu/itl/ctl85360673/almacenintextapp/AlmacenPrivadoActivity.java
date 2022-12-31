/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                                Almacenamiento Privado
:*
:*  Archivo     : MainActivity.java
:*  Autor       : 85360673
:*  Fecha       : 04/12/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Clase para almacenar la información Privada
:*  Ultima modif:
:*  Fecha       Modifico             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.ctl85360673.almacenintextapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class AlmacenPrivadoActivity extends AppCompatActivity {

    private final String FILENAME = "MiArchivo.txt";
    private String texto;
    private EditText edtTextoMultiLinea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen_privado);

        edtTextoMultiLinea = (EditText) findViewById ( R.id.edtTextoMultiLinea );
    }

    public void btnGuardarClick ( View v )
    {
        texto = edtTextoMultiLinea.getText().toString();

        try {
            FileOutputStream fos = this.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write ( texto.getBytes () );
            fos.close();
            Toast.makeText ( this, "Texto ha sido guardado", Toast.LENGTH_LONG ).show();
        } catch ( IOException ex ) {
            Toast.makeText ( this, "ERROR: " + ex, Toast.LENGTH_LONG ).show();
        }
    }

    public void btnLeerClick ( View v ) {

        texto = "";
        int   caracter;

        try {
            FileInputStream fis = this.openFileInput ( FILENAME );
            while ( ( caracter = fis.read() ) != -1 )
               texto += (char) caracter;
            fis.close ();

            edtTextoMultiLinea.setText ( texto );
        } catch ( IOException ex ) {

        }
    }

    public void btnInformacionClick  ( View v ) {
        // Obtener la ruta de la carpeta del almacenamiento interno
        File rutaAlmacenInterno = this.getFilesDir ();
        String carpetaAlmInt = rutaAlmacenInterno.getAbsolutePath ();

        texto = "Carpeta Almacenamiento Privado: " + carpetaAlmInt + "\n";

        // Obtener la lista de archivos en almacen interno
        String archivosList [] = this.fileList ();

        texto += "Archivos: \n";
        for ( String archivo : archivosList ) {
            texto += archivo + "\n";
        }

        edtTextoMultiLinea.setText ( texto );
    }
}
