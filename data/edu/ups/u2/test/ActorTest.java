package edu.ups.u2.test;

import edu.ups.u2.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    @Test
    public void testCrearActor() {
        Actor a = new Actor("Keanu Reeves", 1964, "Canadá");

        Assertions.assertEquals("Keanu Reeves", a.getNombreArtistico());
        Assertions.assertEquals(1964, a.getAnioNacimiento());
        Assertions.assertEquals("Canadá", a.getNacionalidad());
    }

    @Test
    public void testToString() {
        Actor a = new Actor("Keanu Reeves", 1964, "Canadá");

        String texto = a.toString();
        Assertions.assertTrue(texto.contains("Keanu"));
        Assertions.assertTrue(texto.contains("1964"));
    }
}
