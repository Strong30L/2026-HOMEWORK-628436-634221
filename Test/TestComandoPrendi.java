import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class TestComandoPrendi {

    private Partita partita;
    private ComandoPrendi comando;

    @BeforeEach
    void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoPrendi();
    }

    @Test
    void testEseguiPrendeAttrezzoPresente() {
        this.comando.setParametro("osso");
        this.comando.esegui(this.partita);

        assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
    }

    @Test
    void testEseguiRimuoveAttrezzoDallaStanza() {
        this.comando.setParametro("osso");
        this.comando.esegui(this.partita);

        assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("osso"));
    }

    @Test
    void testEseguiNonPrendeAttrezzoAssente() {
        this.comando.setParametro("lanterna");
        this.comando.esegui(this.partita);

        assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
    }
}
