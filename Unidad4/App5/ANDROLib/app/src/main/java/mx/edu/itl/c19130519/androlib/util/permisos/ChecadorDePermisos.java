package mx.edu.itl.c19130519.androlib.util.permisos;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChecadorDePermisos {

    public static final int CODIGO_PEDIR_PERMISOS = 44;

    public static void checarPermisos (Activity activity, PermisoApp[] permisosReq) {
        // Si el arreglo de permisos no trae nada retornamos
        if (permisosReq == null || permisosReq.length == 0)
            return;

        // Verificar cuales permisos estan otorgados y mercalos
        for (int i = 0; i < permisosReq.length; i++) {
            if (ContextCompat.checkSelfPermission(activity, permisosReq[i].getPermiso())
                    ==
                    PackageManager.PERMISSION_GRANTED) {
                permisosReq[i].setOtorgado(true);
            }
        }
        // Determinar la lista de permisos que no estan otorgados
        ArrayList<String> arrTmp = new ArrayList<>();
        for (int i = 0; i < permisosReq.length; i++) {
            if (permisosReq[i].isOtorgado() == false)
                arrTmp.add(permisosReq[i].getPermiso());
        }
        // Si no hay permisos sin otorgar pedirlos explicitamente al usuario
        if( arrTmp.size() > 0){
            // Convertir el arraylist temporal a un arreglo de String
            String [] permisosPendientes = new String [arrTmp.size()];
            arrTmp.toArray( permisosPendientes );

            ActivityCompat.requestPermissions (activity, permisosPendientes, CODIGO_PEDIR_PERMISOS);
        }
    }


    public static void verificarPermisosSolicitados (Activity activity,
                                                     PermisoApp[] permisosReq,
                                                     String [] permissions,
                                                     @NotNull int [] grantResults) {
        ArrayList<String> arrTmp = new ArrayList<>();
        for (int i = 0; i < permisosReq.length; i++)
            arrTmp.add(permisosReq[i].getPermiso());

        String permisosObligatoriosNoOtorgados = "";

        if (grantResults.length > 0 ){
            for (int i = 0; i < grantResults.length; i++){
                // Buscar
                int index = arrTmp.indexOf( permissions [i] );
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    // Registrarlo en el arreglo de permisos de la app
                    permisosReq [index].setOtorgado(true);
                } else if (permisosReq[index].isObligatorio()){
                    // Si no se otorgo un permiso que es obligatorio anexar al string de no otorgado
                    permisosObligatoriosNoOtorgados += permisosReq[index].getNombreCorto() + ", ";
                }
            }
            // checar si hubo permisos obligatorios que no otorgo el usuario
            if( ! permisosObligatoriosNoOtorgados.isEmpty()){
                alteraYSalir (activity, permisosObligatoriosNoOtorgados);
            }
        }
    }
    private static void alteraYSalir(Activity activity, String noOtorgados) {
        // Avisar al usuario que no se puede continuar y salimos del Activity
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Permisos requeridos")
                .setMessage("Los siguientes permisos son necesarios para "+
                        "usar esta funcionalidad: \n\n "+
                        noOtorgados + "\n\n"+
                        "Conceda los permisos cuando se soliciten.")
                .setCancelable(false)
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        activity.finish();
                    }
                })
                .create().show();
    }
}
