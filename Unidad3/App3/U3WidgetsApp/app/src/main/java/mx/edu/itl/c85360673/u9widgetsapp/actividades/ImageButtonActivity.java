package mx.edu.itl.c85360673.u9widgetsapp.actividades;
//  By: RETBOT
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toast;
import android.view.*;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import mx.edu.itl.c85360673.u9widgetsapp.R;
//  By: RETBOT
public class ImageButtonActivity extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_imagebutton);
        /*Add in Oncreate() funtion after setContentView()*/
        ImageButton simpleImageButton = (ImageButton) findViewById(R.id.imageButton1);
        simpleImageButton.setBackgroundColor(Color.BLACK); //set black background color for image button

        // initiate view's
        ImageButton naruto = (ImageButton)findViewById(R.id.imageButton1);

        // perform click event on button's
        naruto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Naruto Button",Toast.LENGTH_LONG).show();// display the toast on home button click
            }
        });

    }//  By: RETBOT
}


