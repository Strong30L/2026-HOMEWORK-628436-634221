import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBloccata {

    private StanzaBloccata stanza;
    private Stanza stanzaNord;

    @BeforeEach
    void setUp() {
        this.stanza = new StanzaBloccata("stanza bloccata", "nord", "chiave");
        this.stanzaNord = new Stanza("nord");
        this.stanza.impostaStanzaAdiacente("nord", this.stanzaNord);
    }

    @Test
    void testGetStanzaAdiacenteBloccataSenzaAttrezzo() {
        assertSame(this.stanza, this.stanza.getStanzaAdiacente("nord"));
    }

    @Test
    void testGetStanzaAdiacenteBloccataConAttrezzo() {
        this.stanza.addAttrezzo(new Attrezzo("chiave", 1));

        assertSame(this.stanzaNord, this.stanza.getStanzaAdiacente("nord"));
    }

    @Test
    void testGetDescrizioneMostraBlocco() {
        assertTrue(this.stanza.getDescrizione().contains("chiave"));
    }
}
