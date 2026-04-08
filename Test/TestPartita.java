import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class TestPartita {

    private Partita partita;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
    }


    /* TEST isFinita*/

    @Test
    void TestisFinita_finita() {
        this.partita.setFinita();
        assertTrue(partita.isFinita());
    }

    @Test
    void TestisFinita_finitaCfu() {
        this.partita.getGiocatore().setCfu(0);
        assertTrue(partita.isFinita());
    }

    @Test
    void TestisFinita_finitaVinta() {
        this.partita.setStanzaCorrente(partita.getStanzaVincente());
        assertTrue(partita.isFinita());
    }


    /* TEST vinta*/

    @Test
    void TestVinta_stanzaObbiettivo() {
        this.partita.setStanzaCorrente(partita.getStanzaVincente());
        assertTrue(this.partita.vinta());
    }

    @Test
    void TestVinta_stanzaNonObbiettivo() {
        this.partita.setStanzaCorrente(partita.getStanzaVincente());
        assertTrue(this.partita.vinta());
        Stanza non_obbiettivo= new Stanza("non obbiettivo");
        this.partita.setStanzaCorrente(non_obbiettivo);
        assertFalse(this.partita.vinta());
    }

    @Test
    void TestVinta_statoIniziale() {
        assertFalse(this.partita.vinta());
    }


    /* TEST Partita*/

    @Test
    void TestPartita_Cfu() {
        assertEquals(20,this.partita.getGiocatore().getCfu());
    }

    @Test
    void TestPartita_nonFinita() {
        assertFalse(this.partita.isFinita());
    }

    @Test
    void TestPartita_statoIniziale() {
        assertEquals("Atrio",this.partita.getStanzaCorrente().getNome()); 
    }

}