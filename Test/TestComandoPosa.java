import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

class TestComandoPosa {

    private Partita partita;
    private ComandoPosa comando;

    @BeforeEach
    void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoPosa();
    }

    @Test
    void testEseguiPosaAttrezzoInStanza() {
        this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("martello", 2));
        this.comando.setParametro("martello");
        this.comando.esegui(this.partita);

        assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("martello"));
    }

    @Test
    void testEseguiRimuoveAttrezzoDaBorsa() {
        this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("martello", 2));
        this.comando.setParametro("martello");
        this.comando.esegui(this.partita);

        assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    void testEseguiNonPosaAttrezzoAssente() {
        this.comando.setParametro("martello");
        this.comando.esegui(this.partita);

        assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("martello"));
    }
}
