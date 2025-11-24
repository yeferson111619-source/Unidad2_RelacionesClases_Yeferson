package edu.ups.u2.vista;

import edu.ups.u2.Actor;
import edu.ups.u2.Documental;
import edu.ups.u2.Pelicula;
import edu.ups.u2.SerieDeTV;

import java.util.List;
import java.util.Scanner;

public class ConsolaVista {

    private final Scanner scanner = new Scanner(System.in);

    // Muestra el menú y devuelve la opción digitada
    public int mostrarMenuPrincipalYLeerOpcion() {
        System.out.println("\n===== MENÚ PRINCIPAL (MVC) =====");
        System.out.println("1. Listar películas");
        System.out.println("2. Listar actores");
        System.out.println("3. Listar documentales");
        System.out.println("4. Listar series de TV");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");

        String linea = scanner.nextLine();
        try {
            return Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
            return -1; // opción inválida
        }
    }

    // Métodos para mostrar listas de modelos

    public void mostrarPeliculas(List<Pelicula> peliculas) {
        System.out.println("\n--- LISTA DE PELÍCULAS ---");
        if (peliculas == null || peliculas.isEmpty()) {
            System.out.println("No hay películas para mostrar.");
            return;
        }
        int i = 0;
        for (Pelicula p : peliculas) {
            System.out.println("[" + i + "] " + p.getTitulo()
                    + " (" + p.getAnio() + ") - " + p.getGenero());
            System.out.println("Elenco: " + p.getElenco());
            System.out.println("------------------------------");
            i++;
        }
    }

    public void mostrarActores(List<Actor> actores) {
        System.out.println("\n--- LISTA DE ACTORES ---");
        if (actores == null || actores.isEmpty()) {
            System.out.println("No hay actores para mostrar.");
            return;
        }
        int i = 0;
        for (Actor a : actores) {
            System.out.println("[" + i + "] " + a.getNombreArtistico()
                    + " | Nacido: " + a.getAnioNacimiento()
                    + " | País: " + a.getNacionalidad());
            System.out.println("------------------------------");
            i++;
        }
    }

    public void mostrarDocumentales(List<Documental> docs) {
        System.out.println("\n--- LISTA DE DOCUMENTALES ---");
        if (docs == null || docs.isEmpty()) {
            System.out.println("No hay documentales para mostrar.");
            return;
        }
        int i = 0;
        for (Documental d : docs) {
            System.out.println("[" + i + "] " + d.getTitulo()
                    + " (" + d.getAnio() + ") - " + d.getGenero());
            if (d.getInvestigador() != null) {
                System.out.println("Investigador: "
                        + d.getInvestigador().getNombre()
                        + " | Especialidad: "
                        + d.getInvestigador().getEspecialidad());
            } else {
                System.out.println("Investigador: (no asignado)");
            }
            System.out.println("------------------------------");
            i++;
        }
    }

    public void mostrarSeries(List<SerieDeTV> series) {
        System.out.println("\n--- LISTA DE SERIES DE TV ---");
        if (series == null || series.isEmpty()) {
            System.out.println("No hay series para mostrar.");
            return;
        }
        int i = 0;
        for (SerieDeTV s : series) {
            System.out.println("[" + i + "] " + s.getTitulo()
                    + " (" + s.getAnio() + ") - " + s.getGenero());
            System.out.println("------------------------------");
            i++;
        }
    }

    // Mensaje genérico
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

