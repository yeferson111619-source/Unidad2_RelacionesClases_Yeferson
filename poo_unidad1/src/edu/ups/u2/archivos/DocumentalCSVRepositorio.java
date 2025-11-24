package edu.ups.u2.archivos;

import edu.ups.u2.Documental;
import edu.ups.u2.Investigador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DocumentalCSVRepositorio implements RepositorioCSV<Documental> {

    @Override
    public List<Documental> leer(String rutaArchivo) throws IOException {

        List<Documental> documentales = new ArrayList<>();
        Path path = Paths.get(rutaArchivo);

        if (!Files.exists(path)) {
            System.out.println("[DOCUMENTALES] El archivo no existe: " + rutaArchivo);
            return documentales;
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String linea;
            int numeroLinea = 0;
            boolean esCabecera = true;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;

                // Saltar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                // Saltar la primera línea si es cabecera
                if (esCabecera) {
                    esCabecera = false;
                    // Podrías validar aquí que tenga el formato esperado
                    // titulo;anio;genero;investigador;especialidad
                    continue;
                }

                String[] partes = linea.split(";");

                if (partes.length < 5) {
                    System.out.println("[DOCUMENTALES] Línea " + numeroLinea +
                            " inválida (se requieren 5 columnas): " + linea);
                    continue;
                }

                String titulo = partes[0].trim();
                String anioTexto = partes[1].trim();
                String genero = partes[2].trim();
                String nombreInv = partes[3].trim();
                String especialidad = partes[4].trim();

                if (titulo.isEmpty() || genero.isEmpty() || nombreInv.isEmpty()) {
                    System.out.println("[DOCUMENTALES] Línea " + numeroLinea +
                            " con campos vacíos (título/género/investigador): " + linea);
                    continue;
                }

                int anio;
                try {
                    anio = Integer.parseInt(anioTexto);
                } catch (NumberFormatException e) {
                    System.out.println("[DOCUMENTALES] Línea " + numeroLinea +
                            " con año inválido: " + linea);
                    continue;
                }

                if (anio < 1900 || anio > 2100) {
                    System.out.println("[DOCUMENTALES] Línea " + numeroLinea +
                            " año fuera de rango: " + linea);
                    continue;
                }

                Documental doc = new Documental(titulo, anio, genero);
                Investigador inv = new Investigador(nombreInv, especialidad);
                doc.asignarInvestigador(inv);

                documentales.add(doc);
            }
        }

        return documentales;
    }

    @Override
    public void guardar(String rutaArchivo, List<Documental> datos) throws IOException {

        if (datos == null) {
            System.out.println("[DOCUMENTALES] Lista nula. Nada que guardar.");
            return;
        }

        Path path = Paths.get(rutaArchivo);

        // Crear carpeta si no existe
        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            // Cabecera del archivo
            bw.write("titulo;anio;genero;investigador;especialidad");
            bw.newLine();

            for (Documental doc : datos) {
                if (doc == null) continue;

                String nombreInv = "";
                String especialidad = "";

                if (doc.getInvestigador() != null) {
                    nombreInv = doc.getInvestigador().getNombre();
                    especialidad = doc.getInvestigador().getEspecialidad();
                }

                String linea = doc.getTitulo() + ";" +
                        doc.getAnio() + ";" +
                        doc.getGenero() + ";" +
                        nombreInv + ";" +
                        especialidad;

                bw.write(linea);
                bw.newLine();
            }
        }
    }
}

