/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                           Mostrar páginas web
:*
:*  Archivo     : WebViewActivity.java
:*  Autor       : Desconocido
:*  Fecha       : 13/10/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Clase que permite la adaptación de un widget para navegar por internet.
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u9widgetsapp.actividades;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import mx.edu.itl.c85360673.u9widgetsapp.R;

public class WebViewActivity extends AppCompatActivity {
    // Variable creada para obtener el webView del activity_web_view
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        //Se obtiene el webView
        webView = ( WebView ) findViewById(R.id.webview);
        //Se crea un nuevo cliente
        webView.setWebViewClient(new WebViewClient());
        //Y se busca una url, en este caso Google
        webView.loadUrl("https://www.google.com");
    }
}