package edu.ups.u2;

import java.util.Objects;

public class Actor {
    private String nombreArtistico;
    private int anioNacimiento;
    private String nacionalidad;

    public Actor(String nombreArtistico, int anioNacimiento, String nacionalidad) {
        this.nombreArtistico = nombreArtistico;
        this.anioNacimiento = anioNacimiento;
        this.nacionalidad = nacionalidad;
    }

    // ============================
    //        GETTERS
    // ============================
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    // ============================
    //        toString()
    // ============================
    @Override
    public String toString() {
        return nombreArtistico + " (" + nacionalidad + ")";
    }

    // ============================
    //       equals & hashCode
    // ============================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(nombreArtistico, actor.nombreArtistico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreArtistico);
    }
}
