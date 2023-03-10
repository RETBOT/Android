/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 10-11 HRS
:*
:*                       Clase main que contiene el codigo del TimePicker
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Alan Francisco Gracia Reyes           17131617
:*                Francisco Daniel Sellschopp Lozano    17130845
:*  Fecha       : 07/11/2021
:*  Compilador  : Android Studio Artic Fox 2020.3.1 + JDK 11
:*  Descripción : Esta clase va a hacer la labor de mostrar el un reloj en donde
:*                se va a seleccionar la fecha.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:------------------------------------------------------------------------------------------*/
package mx.edu.itl.c85360673.u9widgetsapp.actividades;
//  By: RETBOT
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import mx.edu.itl.c85360673.u9widgetsapp.R;

//import mx.edu.itl.c17130845.pickthetime.R;

public class TimerPickerActivity extends AppCompatActivity
{
    Button timeButton;
    int hour, minute;
    String Hora;
//  By: RETBOT
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_picker);
        timeButton = findViewById(R.id.timeButton);
    }

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
                Hora = (selectedHour)+ " : " + (selectedMinute);
                Toast.makeText(timeButton.getContext(),"Hora Seleccionada: "+Hora,Toast.LENGTH_LONG).show();
            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}//  By: RETBOT
