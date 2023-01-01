package mx.edu.itl.c85360673.u4sensoresapp;

//  By: RETBOT

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//  By: RETBOT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnConsultarSensoresClick ( View v ) {
        Intent intent = new Intent ( this, ConsultarSensoresActivity.class );
        startActivity ( intent );
    }
//  By: RETBOT
    public void btnMonitorearSensoresClick ( View v ) {
        Intent intent = new Intent ( this, MonitorearSensoresActivity.class );
        startActivity ( intent );
    }

    public void btnAcelerometroClick ( View v ) {
        Intent intent = new Intent ( this, AcelerometroActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------
    public void btnAcercaDeClick( View v ){
        Toast toast = Toast.makeText(this, "Roberto Esquivel Troncoso 19130519", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}//  By: RETBOT
