package edu.ups.u2.archivos;

import java.io.IOException;
import java.util.List;

public interface RepositorioCSV<T> {

    /**
     * Lee los datos desde un archivo CSV y devuelve una lista de objetos.
     */
    List<T> leer(String rutaArchivo) throws IOException;

    /**
     * Guarda la lista de objetos en un archivo CSV.
     */
    void guardar(String rutaArchivo, List<T> datos) throws IOException;
}