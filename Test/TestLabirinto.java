import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.*;

class TestLabirinto {

	  private Labirinto labirinto;

	    	@BeforeEach
	    public void setUp() {
	        this.labirinto=new Labirinto();
	    }

	    @Test
	    void testLabirinto_stanzaFinale() {
	        assertEquals("Biblioteca",this.labirinto.getStanzaFinale().getNome());
	    }

	    @Test
	    void testLabirinto_stanzaIniziale() {
	        assertEquals("Atrio",this.labirinto.getStanzaIniziale().getNome());
	    }

}
