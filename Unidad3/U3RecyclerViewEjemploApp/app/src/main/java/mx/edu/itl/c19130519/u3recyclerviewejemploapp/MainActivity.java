package mx.edu.itl.c19130519.u3recyclerviewejemploapp;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
//  By: RETBOT
public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> arrlstPersonas;
    private RecyclerView recyclerListaPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerListaPersonas = findViewById(R.id.recyclerViewPersonas);
        llenarListaPersonas();

        ListaPersonasAdapter adapter = new ListaPersonasAdapter(arrlstPersonas);
        recyclerListaPersonas.setAdapter(adapter);
        recyclerListaPersonas.setLayoutManager(new LinearLayoutManager(this));
    }

    public void btnAcercaDeClick( View v ){
        Toast toast = Toast.makeText(this, "Roberto Esquivel Troncoso 19130519", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
//  By: RETBOT
    public void llenarListaPersonas(){
        // llenar el ArrayList de oersibas
        arrlstPersonas = new ArrayList<>();
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));//  By: RETBOT
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));
        arrlstPersonas.add( new Persona("Roberto",23,"Masculino"));
        arrlstPersonas.add( new Persona("Rafael",23,"Masculino"));
        arrlstPersonas.add( new Persona("Isaias",22,"Masculino"));
        arrlstPersonas.add( new Persona("Ivan",22,"Masculino"));
        arrlstPersonas.add( new Persona("Fatima",22,"Femenino"));

    }//  By: RETBOT
}
