/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                       Visa Juego Thread
:*
:*  Archivo     : VisaJuegoThread.java
:*  Autor       : Roberto Esquivel Troncoso   19130519
:*  Fecha       : 28/11/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Clase utilizada para el manejo de hilos en el juego
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
//  By: RETBOT
:*------------------------------------------------------------------------------------------*/


package mx.edu.itl.c19130519.u5juegoasteroidesapp;

import android.util.Log;

public class VistaJuegoThread extends Thread {
    private VistaJuegoView vistaJuegoView;
    private int peroiodoSleep;

    public VistaJuegoThread (VistaJuegoView vistaJuegoView, int peroiodoSleep){
        super();
        this.vistaJuegoView = vistaJuegoView;
        this.peroiodoSleep = peroiodoSleep;
    }//  By: RETBOT
    @Override
    public void run(){
        boolean corriendo = vistaJuegoView.isCorriendo();
        while (corriendo) {
            corriendo = vistaJuegoView.isCorriendo();
            vistaJuegoView.actualizarFisica();
            try {
                Thread.sleep(peroiodoSleep);
            } catch (InterruptedException ex) {
                Log.e("Asteroides", ex.toString());
            }
        }
    }
}
//  By: RETBOT
