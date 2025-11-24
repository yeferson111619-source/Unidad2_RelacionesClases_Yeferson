package edu.ups.u2;

public abstract class ContenidoAudiovisual {
    private String titulo;
    private int anio;
    private String genero;

    public ContenidoAudiovisual(String titulo, int anio, String genero) {
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
    }

    public String getTitulo() { return titulo; }
    public int getAnio() { return anio; }
    public String getGenero() { return genero; }

    /** Cada subclase mostrará su info formateada */
    public abstract String info();

    @Override
    public String toString() { return info(); }
}
