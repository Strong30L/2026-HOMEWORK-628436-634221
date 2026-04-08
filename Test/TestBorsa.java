import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;
import org.junit.jupiter.api.Test;

class TestBorsa {

    private Borsa borsa;

    @Test
    void testBorsa_noArg() {
        this.borsa=new Borsa();
        assertEquals(10,this.borsa.getPesoMax());
    }

    @Test
    void testBorsa_Arg() {
        this.borsa=new Borsa(30);
        assertEquals(30,this.borsa.getPesoMax());
    }

    @Test
    void testAddAttrezzo() {
        this.borsa=new Borsa();
        assertTrue(this.borsa.addAttrezzo(new Attrezzo("piccone",3)));
    }

    @Test
    void testBorsa_hasAttrezzo() {
        this.borsa=new Borsa();
        this.borsa.addAttrezzo(new Attrezzo("piccone",3));
        assertTrue(this.borsa.hasAttrezzo("piccone"));
    }

    @Test
    void testAddAttrezzo_borsaPiena() {
        this.borsa=new Borsa(5);
        assertFalse(this.borsa.addAttrezzo(new Attrezzo("piccone",6)));
    }

    @Test
    void testHasAttrezzo_borsaVuota() {
        this.borsa=new Borsa(5);
        assertFalse(this.borsa.hasAttrezzo("piccone"));
    }

    @Test
    void testIsEmpty() {
        this.borsa=new Borsa(5);
        assertTrue(this.borsa.isEmpty());
    }

    @Test
    void testRemoveAttrezzo() {
        this.borsa=new Borsa();
        this.borsa.addAttrezzo(new Attrezzo("piccone",3));
        assertTrue(this.borsa.hasAttrezzo("piccone"));
        this.borsa.removeAttrezzo("piccone");
        assertFalse(this.borsa.hasAttrezzo("piccone"));
    }

}
