import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.ambienti.StanzaMagicaProtected;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaMagica {

    @Test
    void testAddAttrezzoOltreSogliaModificaNomeEPeso() {
        StanzaMagica stanza = new StanzaMagica("magica", 2);

        stanza.addAttrezzo(new Attrezzo("a", 1));
        stanza.addAttrezzo(new Attrezzo("b", 1));
        stanza.addAttrezzo(new Attrezzo("spada", 4));

        assertNotNull(stanza.getAttrezzo("adaps"));
        assertEquals(8, stanza.getAttrezzo("adaps").getPeso());
    }

    @Test
    void testAddAttrezzoProtectedOltreSogliaModificaNomeEPeso() {
        StanzaMagicaProtected stanza = new StanzaMagicaProtected("magica", 1);

        stanza.addAttrezzo(new Attrezzo("a", 1));
        stanza.addAttrezzo(new Attrezzo("lancia", 3));

        assertNotNull(stanza.getAttrezzo("aicnal"));
        assertEquals(6, stanza.getAttrezzo("aicnal").getPeso());
    }
}
