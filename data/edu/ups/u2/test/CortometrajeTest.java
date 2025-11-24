package edu.ups.u2.test;

import edu.ups.u2.Cortometraje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CortometrajeTest {

    @Test
    public void testDatosCortometraje() {
        Cortometraje c = new Cortometraje("La Jetée", 1962, "Sci-Fi", 28, "Trieste");

        Assertions.assertEquals("La Jetée", c.getTitulo());
        Assertions.assertEquals(28, c.getDuracionMinutos());
    }
}
