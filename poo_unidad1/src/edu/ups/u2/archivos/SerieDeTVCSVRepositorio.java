package edu.ups.u2.archivos;

import edu.ups.u2.SerieDeTV;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SerieDeTVCSVRepositorio implements RepositorioCSV<SerieDeTV> {

    @Override
    public List<SerieDeTV> leer(String rutaArchivo) throws IOException {
        List<SerieDeTV> series = new ArrayList<>();

        Path path = Paths.get(rutaArchivo);
        if (!Files.exists(path)) {
            System.out.println("El archivo no existe: " + rutaArchivo);
            return series;
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                // Saltar la cabecera
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(";");
                if (partes.length < 3) {
                    System.out.println("Línea inválida (esperaba 3 columnas): " + linea);
                    continue;
                }

                String titulo = partes[0];
                int anio = Integer.parseInt(partes[1]);
                String genero = partes[2];

                SerieDeTV serie = new SerieDeTV(titulo, anio, genero);
                series.add(serie);
            }
        }

        return series;
    }

    @Override
    public void guardar(String rutaArchivo, List<SerieDeTV> datos) throws IOException {
        Path path = Paths.get(rutaArchivo);
        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            // Cabecera
            bw.write("titulo;anio;genero");
            bw.newLine();

            for (SerieDeTV s : datos) {
                // Usamos los getters heredados de ContenidoAudiovisual
                String linea = s.getTitulo() + ";"
                        + s.getAnio() + ";"
                        + s.getGenero();
                bw.write(linea);
                bw.newLine();
            }
        }
    }
}
