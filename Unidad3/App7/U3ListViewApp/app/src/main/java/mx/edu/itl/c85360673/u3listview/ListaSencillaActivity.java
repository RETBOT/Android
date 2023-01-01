package mx.edu.itl.c85360673.u3listview;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaSencillaActivity extends AppCompatActivity {

    private final String [] estados = { "Aguascalientes", "Baja California", "Baja California Sur",
            "Campeche","Chiapas","Chihuahua","Ciudad de México","Coahuila","Colima","Durango",
            "Guanajuato","Guerrero","Hidalgo","Jalisco","México","Michoacán","Morelos","Nayarit",
            "Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo","San Luis Potosí","Sinaloa",
            "Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas" } ;

    private final String [] capitales = { "Aguascalientes", "Mexicali", "La Paz","San Francisco de Campeche"
            ,"Tuxtla Gutiérrez","Chihuahua","Ciudad de México","Saltillo","Colima","Victoria de Durango",
            "Guanajuato","Chilpancingo de los Bravo","Pachuca de Soto","Guadalajara","Toluca de Lerdo",
            "Morelia","Cuernavaca","Tepic","Monterrey","Oaxaca de Juárez","Puebla de Zaragoza",
            "Santiago de Querétaro","Chetumal","San Luis Potosí","Culiacán Rosales","Hermosillo",
            "Villahermosa","Ciudad Victoria","Tlaxcala de Xicohténcatl","Xalapa-Enríquez","Mérida",
            "Zacatecas" };
//  By: RETBOT
    private TextView txtvResultado;
    private ListView lstvEstados;
//  By: RETBOT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sencilla);

        txtvResultado = findViewById ( R.id.txtvResultado );
        lstvEstados   = findViewById ( R.id.lstvEstados   );

        // Se crea un ArrayAdapter: El 2o argumento debe ser el id de un recurso TEXTVIEW
        //                          El 3er argumento es la lista de Strings con los que se va a llenar
        ArrayAdapter adaptador = new ArrayAdapter(this, R.layout.list_fila_sencilla, estados);
        lstvEstados.setAdapter( adaptador );

        // Establecemos el listener para el evento OnItemClick  del ListView
        lstvEstados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtvResultado.setText("La capital de " + lstvEstados.getItemAtPosition ( i )+" es "+
                        capitales [ i ] );

                String estado = ( (TextView) view ).getText().toString();
                Toast.makeText(ListaSencillaActivity.this, estado, Toast.LENGTH_SHORT).show();
            }
        });//  By: RETBOT
    }


}
//  By: RETBOT
