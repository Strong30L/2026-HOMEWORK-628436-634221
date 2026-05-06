import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBuia {

    private StanzaBuia stanza;

    @BeforeEach
    void setUp() {
        this.stanza = new StanzaBuia("stanza buia", "lanterna");
    }

    @Test
    void testGetDescrizioneSenzaAttrezzoPerVedere() {
        assertEquals(StanzaBuia.MESSAGGIO_STANZA_BUIA, this.stanza.getDescrizione());
    }

    @Test
    void testGetDescrizioneConAttrezzoPerVedere() {
        this.stanza.addAttrezzo(new Attrezzo("lanterna", 3));

        assertTrue(this.stanza.getDescrizione().contains("stanza buia"));
    }
}
