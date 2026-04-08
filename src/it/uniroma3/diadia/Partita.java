package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco.
 *
 * @author docente di POO
 * @see Stanza, Labirinto, Giocatore
 * @version base
 */
public class Partita {

    private boolean finita;
    private Giocatore giocatore;
    private Labirinto labirinto;
    private Stanza stanzaCorrente;

    public Partita() {
        this.labirinto = new Labirinto();
        this.stanzaCorrente = this.labirinto.getStanzaIniziale();
        this.finita = false;
        this.giocatore = new Giocatore();
    }

    public Giocatore getGiocatore() {
        return this.giocatore;
    }

    public Stanza getStanzaVincente() {
        return this.labirinto.getStanzaFinale();
    }

    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    public boolean vinta() {
        return this.getStanzaCorrente() == this.getStanzaVincente();
    }

    public boolean isFinita() {
        return this.finita || this.vinta() || (this.giocatore.getCfu() == 0);
    }

    public void setFinita() {
        this.finita = true;
    }

   
}