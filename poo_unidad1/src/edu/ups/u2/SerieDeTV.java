package edu.ups.u2;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual {

    private final List<Temporada> temporadas;

    public SerieDeTV(String titulo, int anio, String genero) {
        super(titulo, anio, genero);
        this.temporadas = new ArrayList<>();
    }

    public Temporada crearTemporada(int numero, int anio) {
        Temporada t = new Temporada(numero, anio);
        temporadas.add(t);
        return t;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    @Override
    public String info() {
        int totalEpisodios = temporadas.stream()
                .mapToInt(t -> t.getEpisodios().size())
                .sum();

        return "Serie: " + getTitulo()
                + " (" + getAnio() + ") - " + getGenero()
                + " | Temporadas: " + temporadas.size()
                + " | Episodios: " + totalEpisodios;
    }
}
