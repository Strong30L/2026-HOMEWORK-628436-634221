package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

    private String direzione;
    private IO io;

    public ComandoVai() {
    }

    public ComandoVai(IO io) {
        this.io = io;
    }

    @Override
    public void esegui(Partita partita) {
        if (this.direzione == null) {
            mostraMessaggio("Dove vuoi andare?");
            return;
        }

        Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);

        if (prossimaStanza == null) {
            mostraMessaggio("Direzione inesistente");
        } else {
            partita.setStanzaCorrente(prossimaStanza);
            partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
        }

        mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
        mostraMessaggio("CFU rimasti: " + partita.getGiocatore().getCfu());
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }

    @Override
    public String getNome() {
        return "vai";
    }

    private void mostraMessaggio(String messaggio) {
        if (this.io != null)
            this.io.mostraMessaggio(messaggio);
    }
}
