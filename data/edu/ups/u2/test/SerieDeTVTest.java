package edu.ups.u2.test;

import edu.ups.u2.SerieDeTV;
import edu.ups.u2.Temporada;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SerieDeTVTest {

    @Test
    public void testCrearTemporada() {
        SerieDeTV serie = new SerieDeTV("Dark", 2017, "Misterio");
        Temporada t = serie.crearTemporada(1, 2017);

        Assertions.assertEquals(1, serie.getTemporadas().size());
        Assertions.assertEquals(1, t.getNumero());
    }

    @Test
    public void testInfoIncluyeTitulo() {
        SerieDeTV serie = new SerieDeTV("Dark", 2017, "Misterio");

        String info = serie.info();

        Assertions.assertTrue(info.contains("Dark"));
        Assertions.assertTrue(info.contains("Misterio"));
    }
}
