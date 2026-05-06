package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

    private IO io;

    public ComandoGuarda() {
    }

    public ComandoGuarda(IO io) {
        this.io = io;
    }

    @Override
    public void esegui(Partita partita) {
        mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
        mostraMessaggio("CFU rimasti: " + partita.getGiocatore().getCfu());
        mostraMessaggio(partita.getGiocatore().getBorsa().toString());
    }

    @Override
    public void setParametro(String parametro) {
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public String getNome() {
        return "guarda";
    }

    private void mostraMessaggio(String messaggio) {
        if (this.io != null)
            this.io.mostraMessaggio(messaggio);
    }
}
