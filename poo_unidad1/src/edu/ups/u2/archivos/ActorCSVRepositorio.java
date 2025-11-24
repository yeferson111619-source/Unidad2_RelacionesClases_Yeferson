package edu.ups.u2.archivos;

import edu.ups.u2.Actor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ActorCSVRepositorio implements RepositorioCSV<Actor> {

    @Override
    public List<Actor> leer(String rutaArchivo) throws IOException {

        List<Actor> actores = new ArrayList<>();
        Path path = Paths.get(rutaArchivo);

        if (!Files.exists(path)) {
            System.out.println("[ACTORES] El archivo no existe: " + rutaArchivo);
            return actores;
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(";");

                if (partes.length < 3) {
                    System.out.println("[ACTORES] Línea " + numeroLinea +
                            " inválida (se requieren 3 columnas): " + linea);
                    continue;
                }

                String nombre = partes[0].trim();
                String anioTexto = partes[1].trim();
                String nacionalidad = partes[2].trim();

                if (nombre.isEmpty() || nacionalidad.isEmpty()) {
                    System.out.println("[ACTORES] Línea " + numeroLinea +
                            " con campos vacíos: " + linea);
                    continue;
                }

                int anioNac;
                try {
                    anioNac = Integer.parseInt(anioTexto);
                } catch (NumberFormatException e) {
                    System.out.println("[ACTORES] Línea " + numeroLinea +
                            " con año inválido: " + linea);
                    continue;
                }

                if (anioNac <= 1800 || anioNac > 2024) {
                    System.out.println("[ACTORES] Línea " + numeroLinea +
                            " año fuera de rango: " + linea);
                    continue;
                }

                actores.add(new Actor(nombre, anioNac, nacionalidad));
            }
        }

        return actores;
    }

    @Override
    public void guardar(String rutaArchivo, List<Actor> datos) throws IOException {

        if (datos == null) {
            System.out.println("[ACTORES] Lista nula. Nada que guardar.");
            return;
        }

        Path path = Paths.get(rutaArchivo);

        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            for (Actor actor : datos) {
                if (actor == null) continue;

                bw.write(actor.getNombreArtistico() + ";" +
                        actor.getAnioNacimiento() + ";" +
                        actor.getNacionalidad());
                bw.newLine();
            }
        }
    }
}
