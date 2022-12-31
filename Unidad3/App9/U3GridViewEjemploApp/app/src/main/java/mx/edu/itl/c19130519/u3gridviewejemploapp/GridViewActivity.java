package mx.edu.itl.c19130519.u3gridviewejemploapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    final Integer [] escudos = { R.drawable.club_barcelona, R.drawable.club_bayern,
            R.drawable.club_chelsea, R.drawable.club_dinamokiev, R.drawable.club_zagreb,
            R.drawable.club_realmadrid, R.drawable.club_benfica, R.drawable.club_milan,
            R.drawable.club_tottenham, R.drawable.club_intermilan, R.drawable.club_roterdam
    };

    private GridView grdvClubes;
    private GridAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        grdvClubes = findViewById(R.id.grdvClubes);
        adaptador = new GridAdaptador(this, R.layout.gridview_item_imagen, escudos);
        grdvClubes.setAdapter(adaptador);
        grdvClubes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, GridViewDetalleActivity.class);
        // pasamos como argumento el otro acivity el ID del recurso drawable del escudo seleccionado
        intent.putExtra("escudo", escudos[i]);
        startActivity(intent);
    }

    public class GridAdaptador extends ArrayAdapter{
        private Integer [] escudos;
        private int layoutResId;
        private LayoutInflater inflater;

        // constructor
        public GridAdaptador(@NotNull Context context, int resource, @NotNull Integer [] escudos){
            super(context, resource, escudos);
            this.escudos = escudos;
            layoutResId = resource;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null){
                convertView = inflater.inflate(layoutResId,parent,false);
            }
            ImageView imgEscudo = convertView.findViewById(R.id.imgvEscudo);
            imgEscudo.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(imgEscudo.getContext()).load(escudos[position]).into(imgEscudo);
            return convertView;
        }
    }
}