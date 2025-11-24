package edu.ups.u2.test;

import edu.ups.u2.Documental;
import edu.ups.u2.Investigador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DocumentalTest {

    @Test
    public void testAsignarInvestigador() {
        Documental d = new Documental("Océanos", 2010, "Naturaleza");
        Investigador inv = new Investigador("Dr. Marina", "Biología marina");

        d.asignarInvestigador(inv);

        Assertions.assertNotNull(d.getInvestigador());
        Assertions.assertEquals("Dr. Marina", d.getInvestigador().getNombre());
    }

    @Test
    public void testInfoContieneTitulo() {
        Documental d = new Documental("Océanos", 2010, "Naturaleza");
        String texto = d.info();

        Assertions.assertTrue(texto.contains("Océanos"));
        Assertions.assertTrue(texto.contains("2010"));
    }
}
