package mx.edu.itl.c85360673.CamStudio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//  By: RETBOT
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class verFotos extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    private TextView edtValor;
    private Intent intentOrigen; // Intent que invoco a este activity
    private String carpeta;

    // FOTOS
    private List<String> item = null;
    private String path;
    private GridView grdvFotos;
    private GridAdaptador adaptador;
//  By: RETBOT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_fotos);
        getSupportActionBar().hide();

        edtValor = findViewById(R.id.txtValor);
        intentOrigen = getIntent();
        carpeta = intentOrigen.getStringExtra("carpeta");

        edtValor.setText(carpeta);
        path = Environment.getExternalStorageDirectory().toString() + "/DCIM/" + carpeta ;
        item = new ArrayList<String>();
        File directory = new File(path);
        File[] files = directory.listFiles();

        //Hacemos un Loop por cada fichero para extraer el nombre de cada uno
        for (int i = 0; i < files.length; i++)
        {
            //Sacamos del array files un fichero
            File file = files[i];
            //Si es directorio...
            if (!file.isDirectory())
                item.add(file.getName());
        }

        grdvFotos = findViewById(R.id.grdvFotos);
        adaptador = new GridAdaptador(this, R.layout.gridview_item_imagen, item);
        grdvFotos.setAdapter(adaptador);
        grdvFotos.setOnItemClickListener(this);

        //String archFoto2 = path + edtValor.getText().toString().trim();
        //Toast.makeText(this,"Ruta actual : "+path,Toast.LENGTH_SHORT).show(); // Solo queremos ver la ruta
// El puro valor del EditText
        //    Toast.makeText(this,"Valor del editText: "+edtValor.getText().toString(),Toast.LENGTH_LONG);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, DetalleFoto.class);
        intent.putExtra("Foto", item.get(i));
        intent.putExtra("Carpeta", carpeta);
        startActivity(intent);
    }

//  By: RETBOT
    public class GridAdaptador extends ArrayAdapter {
        private List<String> item = null;
        private int layoutResId;
        private LayoutInflater inflater;

        // constructor
        public GridAdaptador(Context context, int resource, List<String> fotos){
            super(context, resource, fotos);
            this.item = fotos;
            layoutResId = resource;
            inflater = LayoutInflater.from(context);
        }
//  By: RETBOT
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null){
                convertView = inflater.inflate(layoutResId,parent,false);
            }

            ImageView imgvFoto = convertView.findViewById(R.id.imgvFoto);
            imgvFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            String strUri = path + "/" + item.get(position);
            imgvFoto.setImageURI(Uri.parse(strUri));
            //Glide.with(imgvFoto.getContext()).load(item.get(position)).into(imgvFoto);
            return convertView;
        }
    }

    public void btnTomarFotoSimpleClick(View v){
        Intent intent = new Intent(verFotos.this, TomarFoto.class);
        intent.putExtra("carpeta", carpeta);
        startActivity ( intent );
        finish();
    }//  By: RETBOT
}
