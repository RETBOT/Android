package mx.edu.itl.c19130519.u3imcidiomaapp;
//  By: RETBOT
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class OcultarTecladoAdaptador implements View.OnClickListener{
    private Activity activity;

    public OcultarTecladoAdaptador(Activity activity)
    {
        this.activity = activity;
    }
//  By: RETBOT
    @Override
    public void onClick(View view) {
        View vista = activity.getCurrentFocus();
        if ( vista != null ) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService (
                    Context.INPUT_METHOD_SERVICE );
            imm.hideSoftInputFromWindow ( vista.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS );
        }
    }
}//  By: RETBOT
