package edu.ups.u2;

public class Cortometraje extends ContenidoAudiovisual {

    private int duracionMinutos;
    private String festival;

    public Cortometraje(String titulo, int anio, String genero,
                        int duracionMinutos, String festival) {
        super(titulo, anio, genero);
        this.duracionMinutos = duracionMinutos;
        this.festival = festival;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getFestival() {
        return festival;
    }

    @Override
    public String info() {
        return "Cortometraje: " + getTitulo()
                + " (" + getAnio() + "), "
                + getGenero()
                + " - " + duracionMinutos + " min"
                + ", festival: " + festival;
    }
}
