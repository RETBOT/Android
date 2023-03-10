package mx.edu.itl.c85360673.u3spinnerejemploapp;
//  By: RETBOT
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerSimpleActivity extends AppCompatActivity {

    Spinner spnClubesLigaMx;
    String [] clubes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_simple);
//  By: RETBOT
        // Se obtiene la referencia del spinner en el layout
        spnClubesLigaMx = findViewById ( R.id.spnClubesLigaMx );

        // Crear un adaptador ArrayAdapter desde un recurso R.array usando createFromResource ()
        // El 3er argumento es un tipo de TextView. En el simple_spinner_item los elementos salen pegaditos
        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this,
                        R.array.clubres_liga_mx,
                        android.R.layout.simple_spinner_item);
//  By: RETBOT
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnClubesLigaMx.setAdapter(adaptador);

        clubes = getResources().getStringArray(R.array.clubres_liga_mx);

        // Se establece un listener del spinner para los eventos onItemSeelected
        spnClubesLigaMx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s1 = adapterView.getItemAtPosition(i).toString();
                String s2 = ((TextView) view).getText().toString();
                String s3 = clubes[i];

                Toast.makeText(SpinnerSimpleActivity.this, "Club seleccionado :"+s1,
                        Toast.LENGTH_SHORT).show();
            }
//  By: RETBOT
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//  By: RETBOT
    }
}
