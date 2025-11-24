package edu.ups.u2;

public class VideoYouTube extends ContenidoAudiovisual {

    private String canal;
    private String url;
    private int likes;

    public VideoYouTube(String titulo, int anio, String genero, String canal, String url) {
        super(titulo, anio, genero);
        this.canal = canal;
        this.url = url;
        this.likes = 0;
    }

    public void darLike() {
        likes++;
    }

    public int getLikes() {
        return likes;
    }

    public String getCanal() {
        return canal;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String info() {
        return "VideoYouTube: " + getTitulo() + " ("
                + getAnio() + "), "
                + getGenero()
                + " | canal: " + canal
                + " | likes: " + likes
                + " | url: " + url;
    }
}
