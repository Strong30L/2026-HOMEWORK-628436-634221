package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe crea il labirinto e memorizza la stanza iniziale e la stanza finale.
 *
 * @author Filippo e Andrea
 * @see Stanza
 * @version base
 */
public class Labirinto {

    private Stanza stanzaIniziale;
    private Stanza stanzaFinale;

    public Labirinto() {
        creaLabirinto();
    }

    private void creaLabirinto() {

        /* crea gli attrezzi */
        Attrezzo lanterna = new Attrezzo("lanterna", 3);
        Attrezzo osso = new Attrezzo("osso", 1);
        Attrezzo passepartout = new Attrezzo("passepartout", 1);

        /* crea stanze del labirinto */
        Stanza atrio = new Stanza("Atrio");
        Stanza aulaN11 = new StanzaMagica("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new StanzaBloccata("Laboratorio Campus", "ovest", "passepartout");
        Stanza biblioteca = new StanzaBuia("Biblioteca", "lanterna");

        /* collega le stanze */
        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        atrio.impostaStanzaAdiacente("ovest", laboratorio);

        aulaN11.impostaStanzaAdiacente("est", laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);

        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est", aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);

        laboratorio.impostaStanzaAdiacente("est", atrio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);

        biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);
        aulaN11.addAttrezzo(passepartout);

        /* imposta stanza iniziale e finale */
        this.stanzaIniziale = atrio;
        this.stanzaFinale = biblioteca;
    }

    public Stanza getStanzaIniziale() {
        return this.stanzaIniziale;
    }

    public Stanza getStanzaFinale() {
        return this.stanzaFinale;
    }
}
