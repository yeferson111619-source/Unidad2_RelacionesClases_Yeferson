package edu.ups.u2;

import java.util.Objects;

public class Investigador {

    private String nombre;
    private String especialidad;

    public Investigador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // ============================
    //            GETTERS
    // ============================
    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    // ============================
    //           toString
    // ============================
    @Override
    public String toString() {
        return nombre + " (" + especialidad + ")";
    }

    // ============================
    //      equals / hashCode
    // ============================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Investigador)) return false;
        Investigador that = (Investigador) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
