/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 10-11 HRS
:*
:*                Clase de la barra de rating
:*
:*  Archivo     : RatingBarActivity.java
:*  Autor       : Gerardo Salomon Rodriguez Campos     17130831
:*  Fecha       : 08/11/2021
:*  Compilador  : Android Studio Artic Fox 2020.3.1 + JDK 11
:*  Descripci�n : Esta clase se encarga de hacer la barra de rating
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c85360673.u9widgetsapp.actividades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import mx.edu.itl.c85360673.u9widgetsapp.R;

public class RatingBarActivity extends AppCompatActivity {

    private RatingBar rBar;
    private Button btn;
    private TextView tView;
    private double rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
//  By: RETBOT
        // initiate rating bar and a button
        rBar = (RatingBar)findViewById(R.id.ratingBar1);
        btn = (Button)findViewById(R.id.btnCalificacion);
        tView = (TextView) findViewById(R.id.textView1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                rating = rBar.getRating();
                
                String emoji = "";
                if(rating < 2){
                    emoji = "\uD83D\uDE22";
                }else if(rating < 3){
                    emoji = "\uD83D\uDE41";
                }else if(rating < 4){
                    emoji = "\uD83D\uDE10";
                }else if(rating < 5){
                    emoji = "\uD83D\uDE0F";
                }else if(rating < 6){
                    emoji = "\uD83D\uDE0E \uD83E\uDD73";
                }
//  By: RETBOT
                Toast.makeText(RatingBarActivity.this, "Numero de estrellas: "+rating, Toast.LENGTH_SHORT).show();
                tView.setText("Numero de estrellas: "+rating+" "+emoji);
            }
        });
    }
}
