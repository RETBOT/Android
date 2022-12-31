package mx.edu.itl.c85360673.u9widgetsapp.actividades;

import androidx.appcompat.app.AppCompatActivity;
import mx.edu.itl.c85360673.u9widgetsapp.R;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MultilineText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multilinetext);

        final TextView textView = (TextView) findViewById(R.id.test1);
        Button but=(Button) findViewById(R.id.send);
        final EditText edit=(EditText) findViewById(R.id.edit);

        textView.setMovementMethod(new ScrollingMovementMethod()); //Un método de movimiento que interpreta las teclas de movimiento desplazando el búfer de texto.
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=edit.getText().toString();
                textView.append("\n"+text);
            }
        });
    }
}