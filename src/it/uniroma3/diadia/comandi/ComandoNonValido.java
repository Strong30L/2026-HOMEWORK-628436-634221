package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

    private IO io;

    public ComandoNonValido() {
    }

    public ComandoNonValido(IO io) {
        this.io = io;
    }

    @Override
    public void esegui(Partita partita) {
        mostraMessaggio("Comando Sconosciuto");
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
        return "non valido";
    }

    private void mostraMessaggio(String messaggio) {
        if (this.io != null)
            this.io.mostraMessaggio(messaggio);
    }
}
