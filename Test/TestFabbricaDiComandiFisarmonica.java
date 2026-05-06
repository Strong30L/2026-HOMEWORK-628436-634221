import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class TestFabbricaDiComandiFisarmonica {

    private FabbricaDiComandi fabbrica;

    @BeforeEach
    void setUp() {
        this.fabbrica = new FabbricaDiComandiFisarmonica();
    }

    @Test
    void testRiconosceComandoConParametro() {
        Comando comando = this.fabbrica.costruisciComando("vai nord");

        assertEquals("vai", comando.getNome());
        assertEquals("nord", comando.getParametro());
    }

    @Test
    void testRiconosceComandoSenzaParametro() {
        Comando comando = this.fabbrica.costruisciComando("aiuto");

        assertEquals("aiuto", comando.getNome());
        assertNull(comando.getParametro());
    }

    @Test
    void testComandoSconosciutoDiventaNonValido() {
        Comando comando = this.fabbrica.costruisciComando("salta");

        assertEquals("non valido", comando.getNome());
    }

    @Test
    void testRiconosceTuttiIComandiPrevisti() {
        assertEquals("fine", this.fabbrica.costruisciComando("fine").getNome());
        assertEquals("prendi", this.fabbrica.costruisciComando("prendi osso").getNome());
        assertEquals("posa", this.fabbrica.costruisciComando("posa osso").getNome());
        assertEquals("guarda", this.fabbrica.costruisciComando("guarda").getNome());
    }
}
