package mx.edu.itl.c19130519.u3menusapp;
//  By: RETBOT
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class TercerActivity extends MenuComunActivity {

    LinearLayout layout;
//  By: RETBOT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        layout = (LinearLayout) findViewById ( R.id.layoutPrincipal );
    }
//  By: RETBOT
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch ( id ) {
            case R.id.mniCambiarColorFondo:
                layout.setBackgroundColor ( Color.BLUE );
                return true;
            default  :
                return super.onOptionsItemSelected(item);
        }
    }
}
//  By: RETBOT
