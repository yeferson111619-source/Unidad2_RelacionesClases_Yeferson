package edu.ups.u2;

public class Documental extends ContenidoAudiovisual {
    private Investigador investigador; // ASOCIACIÓN 1–1

    public Documental(String titulo, int anio, String genero) {
        super(titulo, anio, genero);
    }

    public void asignarInvestigador(Investigador inv) { this.investigador = inv; }
    public Investigador getInvestigador() { return investigador; }

    @Override
    public String info() {
        return "Documental: " + getTitulo() + " (" + getAnio() + ") - " + getGenero()
                + (investigador != null ? " | Investigador: " + investigador : "");
    }
}
