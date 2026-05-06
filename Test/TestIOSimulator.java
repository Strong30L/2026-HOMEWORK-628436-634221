import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

class TestIOSimulator {

    @Test
    void testLeggiRigaRestituisceComandiInOrdine() {
        IOSimulator io = new IOSimulator(new String[] {"guarda", "fine"});

        assertEquals("guarda", io.leggiRiga());
        assertEquals("fine", io.leggiRiga());
    }

    @Test
    void testMostraMessaggioMemorizzaMessaggi() {
        IOSimulator io = new IOSimulator(new String[] {});

        io.mostraMessaggio("ciao");

        assertEquals(1, io.getNumeroMessaggi());
        assertEquals("ciao", io.getMessaggio(0));
    }

    @Test
    void testDiaDiaConIOSimulatorTerminaPartita() {
        IOSimulator io = new IOSimulator(new String[] {"guarda", "fine"});
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        assertTrue(io.getNumeroMessaggi() > 0);
        assertTrue(contieneMessaggio(io, "Grazie di aver giocato!"));
    }

    private boolean contieneMessaggio(IOSimulator io, String messaggio) {
        for (String messaggioStampato : io.getMessaggi())
            if (messaggio.equals(messaggioStampato))
                return true;
        return false;
    }
}
