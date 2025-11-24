package edu.ups.u2.test;

import edu.ups.u2.Actor;
import edu.ups.u2.Pelicula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeliculaTest {

    @Test
    public void testAgregarActor() {
        Pelicula peli = new Pelicula("Inception", 2010, "Sci-Fi");

        Actor actor = new Actor("Leonardo DiCaprio", 1974, "EEUU");
        peli.agregarActor(actor);

        Assertions.assertEquals(1, peli.getElenco().size());
        Assertions.assertEquals("Leonardo DiCaprio", peli.getElenco().get(0).getNombreArtistico());
    }

    @Test
    public void testInfo() {
        Pelicula peli = new Pelicula("Inception", 2010, "Sci-Fi");
        String resultado = peli.info();

        Assertions.assertTrue(resultado.contains("Inception"));
        Assertions.assertTrue(resultado.contains("2010"));
    }
}
