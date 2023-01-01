package util.permisos;
//  By: RETBOT
public class PermisoApp {
    private String permiso = "";
    private String nombreCorto = "";
    private boolean obligatorio = false;
    private boolean otorgado = false;

    public PermisoApp(String permiso, String nombreCorto, boolean obligatorio) {
        this.permiso = permiso;
        this.nombreCorto = nombreCorto;
        this.obligatorio = obligatorio;
    }

    public String getPermiso() {
        return permiso;
    }
//  By: RETBOT
    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }//  By: RETBOT

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
}//  By: RETBOT
