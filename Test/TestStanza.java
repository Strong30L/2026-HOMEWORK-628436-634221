import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanza{

    private Stanza stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        this.stanza = new Stanza("stanza");
        this.attrezzo = new Attrezzo("osso", 1);
    }

    // TEST getStanzaAdiacente

    @Test
    public void testGetStanzaAdiacenteDirezioneEsistente() {
        Stanza nord = new Stanza("nord");
        stanza.impostaStanzaAdiacente("nord", nord);

        assertEquals(nord, stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteDirezioneInesistente() {
        assertNull(stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testImpostaStanzaAdiacenteAggiornaDirezioneEsistente() {
        Stanza prima = new Stanza("prima");
        Stanza seconda = new Stanza("seconda");

        stanza.impostaStanzaAdiacente("nord", prima);
        stanza.impostaStanzaAdiacente("nord", seconda);

        assertEquals(seconda, stanza.getStanzaAdiacente("nord"));
    }
    //TEST addAttrezzo

    @Test
    public void testAddAttrezzoRiesceSeCestelloNonPieno() {
        assertTrue(stanza.addAttrezzo(attrezzo));
    }

    @Test
    public void testAddAttrezzoInserisceDavveroAttrezzo() {
        stanza.addAttrezzo(attrezzo);

        assertEquals(attrezzo, stanza.getAttrezzo("osso"));
    }

    @Test
    public void testAddAttrezzoFallisceSeStanzaPiena() {
        for (int i = 0; i < 10; i++) {
            stanza.addAttrezzo(new Attrezzo("attrezzo" + i, i));
        }

        assertFalse(stanza.addAttrezzo(new Attrezzo("extra", 99)));
    }

    // TEST hasAttrezzo
    

    @Test
    public void testHasAttrezzoTrueSePresente() {
        stanza.addAttrezzo(attrezzo);

        assertTrue(stanza.hasAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzoFalseSeAssente() {
        assertFalse(stanza.hasAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzoFalseSePresenteAltroAttrezzo() {
        stanza.addAttrezzo(new Attrezzo("lanterna", 3));

        assertFalse(stanza.hasAttrezzo("osso"));
    }

    // TEST GetAttrezzo

    @Test
    public void testGetAttrezzoRestituisceAttrezzoEsistente() {
        stanza.addAttrezzo(attrezzo);

        assertEquals(attrezzo, stanza.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezzoRestituisceNullSeAssente() {
        assertNull(stanza.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezzoConPiuAttrezziRestituisceQuelloGiusto() {
        Attrezzo lanterna = new Attrezzo("lanterna", 3);
        stanza.addAttrezzo(lanterna);
        stanza.addAttrezzo(attrezzo);

        assertEquals(attrezzo, stanza.getAttrezzo("osso"));
    }
    
    // TEST removeAttrezzo 

    @Test
    public void testRemoveAttrezzoRestituisceTrueSeAttrezzoPresente() {
        stanza.addAttrezzo(attrezzo);

        assertTrue(stanza.removeAttrezzo(attrezzo));
    }

    @Test
    public void testRemoveAttrezzoEliminaAttrezzoPresente() {
        stanza.addAttrezzo(attrezzo);
        stanza.removeAttrezzo(attrezzo);

        assertFalse(stanza.hasAttrezzo("osso"));
    }

    @Test
    public void testRemoveAttrezzoRestituisceFalseSeAttrezzoAssente() {
        assertFalse(stanza.removeAttrezzo(attrezzo));
    }

   
}
   
    
	
