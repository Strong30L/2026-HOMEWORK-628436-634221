import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.giocatore.*;

class TestGiocatore {

    private Giocatore giocatore;

    @BeforeEach
    public void setUp() {
        this.giocatore = new Giocatore();
    }

    // TEST Giocatore()

    @Test
    public void testGiocatore_borsa() {
        assertNotNull(this.giocatore.getBorsa());
    }

    @Test
    public void testGiocatore_cfuIniziali() {
        assertEquals(20,this.giocatore.getCfu());
    }

    @Test
    public void testGiocatore_setCfu() {
        this.giocatore.setCfu(10);
        assertEquals(10,this.giocatore.getCfu());
    }

}
