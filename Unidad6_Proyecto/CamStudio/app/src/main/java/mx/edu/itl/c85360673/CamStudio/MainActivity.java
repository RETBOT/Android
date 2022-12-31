package mx.edu.itl.c85360673.CamStudio;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import mx.edu.itl.c19130519.androlib.util.permisos.ChecadorDePermisos;
import mx.edu.itl.c19130519.androlib.util.permisos.PermisoApp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ActivityResultCallback<ActivityResult> {

    // permisos de la app
    private PermisoApp[] permisosReq = new PermisoApp [] {
            new PermisoApp(Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true),
            new PermisoApp(Manifest.permission.WRITE_EXTERNAL_STORAGE, "Almacenamiento", true),
            new PermisoApp(Manifest.permission.CAMERA, "Camara", true),
    };

    // Ruta para el inicio de las carpetas
    private String path; // carpeta
    private String ruta; // video

    // para las carpetas
    private List<String> item = null;
    private ActivityResultLauncher<Intent> activityResultLaunch;

    // Componentes floating
    FloatingActionButton fab; // Objeto para el floating del simbolo mas
    FloatingActionButton fab1; // Objeto para floating del simbolo de la carpeta

    // Definimos objetos para las animaciones
    Animation fabOpen, fabClose, rotateFoward, rotateBackward;
    boolean isOpen = false; // Creamos bandera para verificar si el usuario ha dado click o no

    // ELementos necesarios para inflar el layout de creacion de las carpetas
    private EditText edNombreCarpeta;
    private View vista_crearCarpetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // permisos de la aplicacion
        ChecadorDePermisos.checarPermisos(this, permisosReq);

        // Ruta actual
        path = Environment.getExternalStorageDirectory().toString() + "/DCIM/";
        // ver carpetas
        item = new ArrayList<String>();
        File directory = new File(path);
        File[] files = directory.listFiles();
        //Hacemos un Loop por cada fichero para extraer el nombre de cada uno
        for (int i = 0; i < files.length; i++)
        {
            //Sacamos del array files un fichero
            File file = files[i];
            //Si es directorio...
            if (file.isDirectory()) {
                String arc = file.getName().toString();
                if ( arc.charAt(0) != '.'){ // si contiene un . es un archivo del sistema
                    item.add(file.getName());
                }
            }
            //Si es fichero...
            //else
            //  item.add(file.getName());

            //Localizamos y llenamos la lista
            ListView lstOpciones = (ListView) findViewById(R.id.listaFiles);
            ArrayAdapter<String> fileList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
            lstOpciones.setAdapter(fileList);

            // Accion para realizar al pulsar sobre la lista
            lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                    Toast.makeText(MainActivity.this,
                            "Carpeta seleccionada : "+item.get(position),
                            Toast.LENGTH_SHORT).show();

                    verFotos(v, position);
                }
            });
        }


// Inicializamos los floating relacionando el objeto con el objeto GUI
        fab = (FloatingActionButton) findViewById(R.id.fabMas); // FAB BOTON MAS
        fab1 = (FloatingActionButton) findViewById(R.id.fabCarpeta); // FAB BOTON CARPETA
        fab1.setVisibility(View.INVISIBLE); // Que no se vea el fab
// Inicializamos las animaciones
        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotateFoward = AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this,R.anim.rotate_backward);

        // Ponemos los listerner para cuando el usuario le de click
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   fabCrearCarpetaClick(v);
                animateFab();
            }
        });
        // Listener para cuando se de click sobre la carpeta
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                fabCrearCarpetaClick(v);
                Toast.makeText(MainActivity.this,"Haz dadoc click sobre la carpeta",Toast.LENGTH_LONG).show();
                // Inflamos el layout para que nos aparezca el dialogo
                // vista_crearCarpetas = this.getLayoutInflater().inflate(R.layout.activity_crear_carpeta,null);
            }
        });
    }

    //----------------------------------------------------------------------------------------------
    // metodos
    public void verFotos(View v, int position) {
        // Preparamos el Intent para el segundo Activity
        Intent intent = new Intent( this,verFotos.class );
        // Pasar el valor del peso como un float
        intent.putExtra("carpeta",item.get(position));
        startActivity(intent);
    }
    public void animateFab(){
        if(isOpen){
            fab.startAnimation(rotateFoward);
            fab1.startAnimation(fabClose);
            fab1.setClickable(false);
            fab1.setVisibility(View.INVISIBLE);
            isOpen =  false;
        }
        else{
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab1.setVisibility(View.VISIBLE);
            fab1.setClickable(true);
            isOpen = true;
        }
    }
    public void fabCrearCarpetaClick(View v) {
// Obtenemos la referencia del layout a incrustrar
        vista_crearCarpetas = this.getLayoutInflater().inflate(R.layout.activity_crear_carpeta,null);
        edNombreCarpeta =  vista_crearCarpetas.findViewById(R.id.edtCarpeta);
        // Preparamos el mensaje
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Creacion de carpetas").setView(vista_crearCarpetas)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String texto = edNombreCarpeta.getText().toString();
                        // Verificamos el paraemtro
                        // Toast.makeText(this, "El texto introducido fue : "+texto,Toast.LENGTH_LONG).show();

                        Toast.makeText(MainActivity.this,"El texto introducido fue : "+texto,Toast.LENGTH_SHORT).show();
                        // Insertar funcionalidad
                        crearDirectorio(texto);
                        // Recargamos el layout
                        //setContentView(R.layout.activity_main);
                        recreate(); // Si funciona, pero veremos otra alternativa
                        //  getWindow().getDecorView().findViewById(android.R.id.content).invalidate(); // No jala
                        v.refreshDrawableState();
                        // Mostramos el path
                        //  Toast.makeText(MainActivity.this,crearDirectorio(texto).getPath()+"",Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setCancelable(false).create().show();
    }
    // Metodo para la creacion de las carpetas.
    private File crearDirectorio(String dirName){
        //  File file = new File(getExternalFilesDir(null)+ "/"+dirName);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),dirName);
        if(!file.exists()){
            file.mkdir();
            Toast.makeText(this, "Carpeta creada correctamente",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"La carpeta no se pudo crear",Toast.LENGTH_SHORT).show();
        }
        return file;
    }
    private void  lanzarVideoActiviy () {
        Intent intent = new Intent ( this, AcercaDe.class ) ;
        intent.putExtra ( "rutaVideo", ruta );
        startActivity ( intent );
    }


    //----------------------------------------------------------------------------------------------
    // Creamos el menu de la Actividad que aparecerá en la barra de acciones (ActionBar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate ( R.menu.menu_main_activity, menu );
        return super.onCreateOptionsMenu(menu);
    }

    // Manejamos las selecciones en el menu de la Actividad
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch ( id ) {
            case R.id.mniAcercaDe : ruta = "android.resource://" + this.getPackageName() + "/" + R.raw.acercade;
                    lanzarVideoActiviy ();
                break;
            case R.id.mniSalir : finish ();
            default                 : return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onBackPressed () {
        // Hacer nada cuando se pulse el boton ATRAS del dispositivo
        Toast.makeText ( this, "Use la opcion Salir del menu", Toast.LENGTH_SHORT ).show ();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS){
            ChecadorDePermisos.verificarPermisosSolicitados(this, permisosReq, permissions, grantResults);
        }
    }

    @Override
    public void onActivityResult(ActivityResult result) {

    }
}