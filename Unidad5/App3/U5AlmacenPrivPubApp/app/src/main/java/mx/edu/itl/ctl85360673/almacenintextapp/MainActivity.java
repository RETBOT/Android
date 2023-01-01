/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                                Clase principal
:*
:*  Archivo     : MainActivity.java
:*  Autor       : //  By: RETBOT
:*  Fecha       : 04/12/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : Clase principal para redireccionar a las diferentes formas de almacenar Publica/Privada
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.ctl85360673.almacenintextapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//  By: RETBOT
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAlmacenPrivClick ( View v ) {
        Intent intent = new Intent ( this, AlmacenPrivadoActivity.class );
        startActivity ( intent );
    }

    public void btnAlmacenPubClick ( View v ) {
        Intent intent = new Intent ( this, AlmacenPublicoActivity.class );
        startActivity ( intent );

    }//  By: RETBOT

    public void btnAcercaDeClick( View v ){
        Toast toast = Toast.makeText(this, "Roberto Esquivel Troncoso 19130519", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}
//  By: RETBOT
