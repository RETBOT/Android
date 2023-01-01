package mx.edu.itl.c19130519.u3recyclerviewejemploapp;
//  By: RETBOT
public class Persona {
    private String nombre;
    private int    edad;
    private String sexo;

    public Persona() {
        nombre = "Null";
        edad = 0;
        sexo = "Null";
    }

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }//  By: RETBOT

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
//  By: RETBOT
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
//  By: RETBOT
