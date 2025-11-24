package edu.ups.u2.controlador;

import edu.ups.u2.Actor;
import edu.ups.u2.Documental;
import edu.ups.u2.Pelicula;
import edu.ups.u2.SerieDeTV;
import edu.ups.u2.archivos.ActorCSVRepositorio;
import edu.ups.u2.archivos.DocumentalCSVRepositorio;
import edu.ups.u2.archivos.PeliculaCSVRepositorio;
import edu.ups.u2.archivos.SerieDeTVCSVRepositorio;
import edu.ups.u2.vista.ConsolaVista;

import java.io.IOException;
import java.util.List;

public class ContenidoController {

    private final ConsolaVista vista;
    private final PeliculaCSVRepositorio peliculaRepo;
    private final ActorCSVRepositorio actorRepo;
    private final DocumentalCSVRepositorio documentalRepo;
    private final SerieDeTVCSVRepositorio serieRepo;

    // Rutas de archivos (las mismas que usas en Main)
    private static final String RUTA_PELICULAS = "data/peliculas.csv";
    private static final String RUTA_ACTORES = "data/actores.csv";
    private static final String RUTA_DOCS = "data/documentales.csv";
    private static final String RUTA_SERIES = "data/series.csv";

    public ContenidoController() {
        this.vista = new ConsolaVista();
        this.peliculaRepo = new PeliculaCSVRepositorio();
        this.actorRepo = new ActorCSVRepositorio();
        this.documentalRepo = new DocumentalCSVRepositorio();
        this.serieRepo = new SerieDeTVCSVRepositorio();
    }

    // Método principal del controlador (bucle del menú)
    public void iniciar() {

        boolean seguir = true;

        while (seguir) {
            int opcion = vista.mostrarMenuPrincipalYLeerOpcion();

            switch (opcion) {
                case 1 -> listarPeliculas();
                case 2 -> listarActores();
                case 3 -> listarDocumentales();
                case 4 -> listarSeries();
                case 0 -> {
                    vista.mostrarMensaje("Saliendo del sistema MVC...");
                    seguir = false;
                }
                default -> vista.mostrarMensaje("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    // Métodos privados para cada opción del menú

    private void listarPeliculas() {
        try {
            List<Pelicula> peliculas = peliculaRepo.leer(RUTA_PELICULAS);
            vista.mostrarPeliculas(peliculas);
        } catch (IOException e) {
            vista.mostrarMensaje("[ERROR] No se pudieron leer las películas: " + e.getMessage());
        }
    }

    private void listarActores() {
        try {
            List<Actor> actores = actorRepo.leer(RUTA_ACTORES);
            vista.mostrarActores(actores);
        } catch (IOException e) {
            vista.mostrarMensaje("[ERROR] No se pudieron leer los actores: " + e.getMessage());
        }
    }

    private void listarDocumentales() {
        try {
            List<Documental> docs = documentalRepo.leer(RUTA_DOCS);
            vista.mostrarDocumentales(docs);
        } catch (IOException e) {
            vista.mostrarMensaje("[ERROR] No se pudieron leer los documentales: " + e.getMessage());
        }
    }

    private void listarSeries() {
        try {
            List<SerieDeTV> series = serieRepo.leer(RUTA_SERIES);
            vista.mostrarSeries(series);
        } catch (IOException e) {
            vista.mostrarMensaje("[ERROR] No se pudieron leer las series: " + e.getMessage());
        }
    }
}
