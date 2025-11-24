package edu.ups.u2;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual {
    private final List<Actor> elenco = new ArrayList<>();

    public Pelicula(String titulo, int anio, String genero) {
        super(titulo, anio, genero);
    }

    public void agregarActor(Actor actor) {
        if (actor != null && !elenco.contains(actor)) elenco.add(actor);
    }

    public List<Actor> getElenco() {
        return List.copyOf(elenco);
    }

    @Override
    public String info() {
        return "Pelicula: " + getTitulo() + " (" + getAnio() + ") - " + getGenero()
                + " | Elenco: " + elenco;
    }
}
