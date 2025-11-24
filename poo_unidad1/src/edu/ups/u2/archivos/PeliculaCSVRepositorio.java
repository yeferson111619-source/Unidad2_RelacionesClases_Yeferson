package edu.ups.u2.archivos;

import edu.ups.u2.Pelicula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para leer y escribir Películas en formato CSV.
 * Formato esperado por línea:
 * titulo;anioOduracion;genero
 */
public class PeliculaCSVRepositorio implements RepositorioCSV<Pelicula> {

    @Override
    public List<Pelicula> leer(String rutaArchivo) throws IOException {
        List<Pelicula> peliculas = new ArrayList<>();

        Path path = Paths.get(rutaArchivo);

        if (!Files.exists(path)) {
            System.out.println("[PELÍCULAS] El archivo no existe: " + rutaArchivo);
            return peliculas; // lista vacía
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;

                // Saltar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(";");

                // Validar número de columnas
                if (partes.length < 3) {
                    System.out.println("[PELÍCULAS] Línea " + numeroLinea +
                            " inválida (se esperaban 3 columnas): " + linea);
                    continue; // saltar esta línea
                }

                String titulo = partes[0].trim();
                String anioTexto = partes[1].trim();
                String genero = partes[2].trim();

                // Validar campos no vacíos
                if (titulo.isEmpty() || genero.isEmpty()) {
                    System.out.println("[PELÍCULAS] Línea " + numeroLinea +
                            " con datos vacíos (título/género): " + linea);
                    continue;
                }

                // Validar número (año o duración)
                int anioODuracion;
                try {
                    anioODuracion = Integer.parseInt(anioTexto);
                } catch (NumberFormatException e) {
                    System.out.println("[PELÍCULAS] Línea " + numeroLinea +
                            " con número inválido en la segunda columna: " + linea);
                    continue;
                }

                // Validar rango básico
                if (anioODuracion <= 0) {
                    System.out.println("[PELÍCULAS] Línea " + numeroLinea +
                            " con año/duración no positivo: " + linea);
                    continue;
                }

                // Crear la película
                Pelicula p = new Pelicula(titulo, anioODuracion, genero);
                peliculas.add(p);
            }
        }

        return peliculas;
    }

    @Override
    public void guardar(String rutaArchivo, List<Pelicula> datos) throws IOException {

        if (datos == null) {
            System.out.println("[PELÍCULAS] Lista de datos nula, nada que guardar.");
            return;
        }

        Path path = Paths.get(rutaArchivo);

        // Crear carpetas si no existen
        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            // No usamos cabecera aquí porque tu archivo original no la tenía
            for (Pelicula p : datos) {
                if (p == null) {
                    continue;
                }
                String linea = p.getTitulo() + ";"
                        + p.getAnio() + ";"
                        + p.getGenero();
                bw.write(linea);
                bw.newLine();
            }
        }
    }
}

