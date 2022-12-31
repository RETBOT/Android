/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                       Clase solo para diseno
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Roberto Esquivel Troncoso  19130519
:*  Fecha       : 04/Oct/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripci�n : En esta clase no se hizo algo especial en cuanto a codigo,
:*                 solamente usamos el layout para el diseno de nuestro acerca de.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c19130519.u3imcidiomaapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AcercaDeActivity extends AppCompatActivity {
    //--------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade_layout);
    }
}