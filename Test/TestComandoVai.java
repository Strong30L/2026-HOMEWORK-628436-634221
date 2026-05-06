import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.ComandoVai;

class TestComandoVai {

    private Partita partita;
    private ComandoVai comando;

    @BeforeEach
    void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoVai();
    }

    @Test
    void testEseguiSpostaStanzaDirezioneEsistente() {
        this.comando.setParametro("nord");
        this.comando.esegui(this.partita);

        assertEquals("Biblioteca", this.partita.getStanzaCorrente().getNome());
    }

    @Test
    void testEseguiScalaCfuSeDirezioneEsistente() {
        this.comando.setParametro("nord");
        this.comando.esegui(this.partita);

        assertEquals(19, this.partita.getGiocatore().getCfu());
    }

    @Test
    void testEseguiNonSpostaSeDirezioneInesistente() {
        this.comando.setParametro("alto");
        this.comando.esegui(this.partita);

        assertEquals("Atrio", this.partita.getStanzaCorrente().getNome());
    }

    @Test
    void testEseguiNonScalaCfuSeDirezioneInesistente() {
        this.comando.setParametro("alto");
        this.comando.esegui(this.partita);

        assertEquals(20, this.partita.getGiocatore().getCfu());
    }
}
