package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

    private IO io;

    public ComandoFine() {
    }

    public ComandoFine(IO io) {
        this.io = io;
    }

    @Override
    public void esegui(Partita partita) {
        mostraMessaggio("Grazie di aver giocato!");
        partita.setFinita();
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
        return "fine";
    }

    private void mostraMessaggio(String messaggio) {
        if (this.io != null)
            this.io.mostraMessaggio(messaggio);
    }
}
