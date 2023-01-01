package mx.edu.itl.c19130519.u3imcidiomaapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
//  By: RETBOT
public class OcultarTecladoAdaptador implements View.OnClickListener
{
    // Atributo
    private Activity activity;

    // constructor
    public OcultarTecladoAdaptador( Activity activity ){
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        // Ocultar el teclado en pantalla
        View vista = activity.getCurrentFocus();
        if (vista != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vista.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);

        }//  By: RETBOT
    }
}
//  By: RETBOT
