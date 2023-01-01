package mx.edu.itl.c85360673.CamStudio;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class CrearCarpeta extends AppCompatActivity {

    // En esta clase solo desplegaremos el cuadro para el usuario cree la carpeta.
    private EditText edNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carpeta);

        // Le decimos que tome la info de aqui
        edNombre = findViewById(R.id.edtCarpeta);

    }
}//  By: RETBOT
