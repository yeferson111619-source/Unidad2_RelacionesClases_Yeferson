package edu.ups.u2;

import java.util.ArrayList;
import java.util.List;

public class Temporada {

    private int numero;
    private int anio;
    private final List<String> episodios;

    public Temporada(int numero, int anio) {
        this.numero = numero;
        this.anio = anio;
        this.episodios = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public int getAnio() {
        return anio;
    }

    public List<String> getEpisodios() {
        return episodios;
    }

    public void agregarEpisodio(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            episodios.add(nombre);
        }
    }

    public String info() {
        return "Temporada " + numero +
                " (" + anio + "), Episodios: " + episodios.size();
    }
}
