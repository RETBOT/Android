package mx.edu.itl.c19130519.u3gridviewejemploapp;
//  By: RETBOT
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GridViewDetalleActivity extends AppCompatActivity {
//  By: RETBOT
    private ImageView imgvEscudoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_detalle);
        getSupportActionBar().hide();

        imgvEscudoDetalle = findViewById(R.id.imgvEscudoDetalle);
        Integer escudo = getIntent().getIntExtra("escudo",0);
        imgvEscudoDetalle.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(imgvEscudoDetalle.getContext()).load(escudo).into(imgvEscudoDetalle);
    }
}//  By: RETBOT
