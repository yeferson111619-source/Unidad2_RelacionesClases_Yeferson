package edu.ups.u2;

import edu.ups.u2.archivos.ActorCSVRepositorio;
import edu.ups.u2.archivos.PeliculaCSVRepositorio;
import edu.ups.u2.archivos.DocumentalCSVRepositorio;
import edu.ups.u2.archivos.SerieDeTVCSVRepositorio;
import edu.ups.u2.controlador.ContenidoController;

import java.util.List;

public class MainPruebas {

    // ============================================================
    // CONSTANTES DE RUTAS (para evitar cadenas repetidas)
    // ============================================================
    private static final String RUTA_PELICULAS_ENTRADA = "data/peliculas.csv";
    private static final String RUTA_PELICULAS_SALIDA  = "data/peliculas_salida.csv";

    private static final String RUTA_ACTORES_ENTRADA   = "data/actores.csv";
    private static final String RUTA_ACTORES_SALIDA    = "data/actores_salida.csv";

    private static final String RUTA_DOCS_ENTRADA      = "data/documentales.csv";
    private static final String RUTA_DOCS_SALIDA       = "data/documentales_salida.csv";

    private static final String RUTA_SERIES_ENTRADA    = "data/series.csv";
    private static final String RUTA_SERIES_SALIDA     = "data/series_salida.csv";

    // ============================================================
    // MÉTODO PRINCIPAL
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=== INICIO DEL PROGRAMA ===\n");

        // Parte 1: Relaciones entre clases (en memoria)
        probarRelacionesEntreClases();

        // Parte 2: Lectura/escritura de Películas CSV
        probarPeliculasCSV();

        // Parte 3: Lectura/escritura de Actores CSV
        probarActoresCSV();

        // Parte 4: Lectura/escritura de Documentales CSV
        probarDocumentalesCSV();

        // Parte 5: Lectura/escritura de Series de TV CSV
        probarSeriesCSV();

        // ================== ETAPA 4: PATRÓN MVC ==================
        System.out.println("\n=== INICIO DEL MÓDULO MVC ===");
        ContenidoController controller = new ContenidoController();
        controller.iniciar();
        // =========================================================

        System.out.println("\nFIN DEL PROGRAMA");
    }

    // ============================================================
    // PARTE 1: RELACIONES ENTRE CLASES (SIN ARCHIVOS)
    // ============================================================
    private static void probarRelacionesEntreClases() {

        // Película + Actores
        Pelicula pelicula = new Pelicula("Inception", 2010, "Sci-Fi");
        pelicula.agregarActor(new Actor("Leonardo DiCaprio", 1974, "EEUU"));
        pelicula.agregarActor(new Actor("Joseph Gordon-Levitt", 1981, "EEUU"));
        System.out.println(pelicula.info());

        // Serie + Temporadas
        SerieDeTV serie = new SerieDeTV("Dark", 2017, "Misterio");
        Temporada t1 = serie.crearTemporada(1, 2017);
        t1.agregarEpisodio("Secretos");
        t1.agregarEpisodio("Mentiras");

        Temporada t2 = serie.crearTemporada(2, 2019);
        t2.agregarEpisodio("Principios y finales");

        System.out.println(serie.info());

        // Documental + Investigador
        Documental doc = new Documental("Planeta Azul", 2001, "Naturaleza");
        doc.asignarInvestigador(new Investigador("Dr. Cousteau", "Oceanografía"));
        System.out.println(doc.info());

        // Cortometraje
        Cortometraje corto = new Cortometraje("La Jetée", 1962, "Sci-Fi", 28, "Trieste");
        System.out.println(corto.info());

        // Video de YouTube
        VideoYouTube video = new VideoYouTube(
                "POO en 15 minutos",
                2024,
                "Educación",
                "DevEnEspañol",
                "https://youtu.be/xxxxx"
        );
        video.darLike();
        video.darLike();
        System.out.println(video.info());
    }

    // ============================================================
    // PARTE 2: LECTURA Y ESCRITURA DE PELÍCULAS CSV
    // ============================================================
    private static void probarPeliculasCSV() {

        System.out.println("\n=== Lectura de películas desde CSV ===");

        PeliculaCSVRepositorio repoPelis = new PeliculaCSVRepositorio();

        try {
            List<Pelicula> peliculasLeidas = repoPelis.leer(RUTA_PELICULAS_ENTRADA);

            int indice = 0;
            for (Pelicula peli : peliculasLeidas) {
                System.out.println("Registro #" + indice);
                System.out.println("Película: " + peli.getTitulo()
                        + " (" + peli.getAnio() + ") - " + peli.getGenero());
                System.out.println("Elenco: " + peli.getElenco());
                imprimirSeparador();
                indice++;
            }

            repoPelis.guardar(RUTA_PELICULAS_SALIDA, peliculasLeidas);
            System.out.println("Películas guardadas en: " + RUTA_PELICULAS_SALIDA);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // PARTE 3: LECTURA Y ESCRITURA DE ACTORES CSV
    // ============================================================
    private static void probarActoresCSV() {

        System.out.println("\n=== Lectura de actores desde CSV ===");

        ActorCSVRepositorio repoAct = new ActorCSVRepositorio();

        try {
            List<Actor> actores = repoAct.leer(RUTA_ACTORES_ENTRADA);

            for (Actor actor : actores) {
                System.out.println("Nombre: " + actor.getNombreArtistico());
                System.out.println("Nacimiento: " + actor.getAnioNacimiento());
                System.out.println("Nacionalidad: " + actor.getNacionalidad());
                imprimirSeparador();
            }

            repoAct.guardar(RUTA_ACTORES_SALIDA, actores);
            System.out.println("Actores guardados en: " + RUTA_ACTORES_SALIDA);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // PARTE 4: LECTURA Y ESCRITURA DE DOCUMENTALES CSV
    // ============================================================
    private static void probarDocumentalesCSV() {

        System.out.println("\n=== Lectura de documentales desde CSV ===");

        DocumentalCSVRepositorio repoDoc = new DocumentalCSVRepositorio();

        try {
            List<Documental> docs = repoDoc.leer(RUTA_DOCS_ENTRADA);

            for (Documental doc : docs) {
                System.out.println("Título: " + doc.getTitulo());
                System.out.println("Año: " + doc.getAnio());
                System.out.println("Género: " + doc.getGenero());

                if (doc.getInvestigador() != null) {
                    System.out.println("Investigador: "
                            + doc.getInvestigador().getNombre()
                            + " | Especialidad: "
                            + doc.getInvestigador().getEspecialidad());
                } else {
                    System.out.println("Investigador: (no asignado)");
                }

                imprimirSeparador();
            }

            repoDoc.guardar(RUTA_DOCS_SALIDA, docs);
            System.out.println("Documentales guardados en: " + RUTA_DOCS_SALIDA);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // PARTE 5: LECTURA Y ESCRITURA DE SERIES DE TV CSV
    // ============================================================
    private static void probarSeriesCSV() {

        System.out.println("\n=== Lectura de series de TV desde CSV ===");

        SerieDeTVCSVRepositorio repoSeries = new SerieDeTVCSVRepositorio();

        try {
            List<SerieDeTV> series = repoSeries.leer(RUTA_SERIES_ENTRADA);

            for (SerieDeTV serie : series) {
                System.out.println("Serie: " + serie.getTitulo()
                        + " (" + serie.getAnio() + ") - " + serie.getGenero());
                imprimirSeparador();
            }

            repoSeries.guardar(RUTA_SERIES_SALIDA, series);
            System.out.println("Series guardadas en: " + RUTA_SERIES_SALIDA);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // MÉTODO DE APOYO (ELIMINA CÓDIGO DUPLICADO)
    // ============================================================
    private static void imprimirSeparador() {
        System.out.println("------------------------------");
    }
}

