package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

    private IO io;

    static final private String[] ELENCO_COMANDI = {
        "vai",
        "aiuto",
        "fine",
        "prendi",
        "posa",
        "guarda"
    };

    public ComandoAiuto() {
    }

    public ComandoAiuto(IO io) {
        this.io = io;
    }

    @Override
    public void esegui(Partita partita) {
        mostraMessaggio("comandi disponibili:");
        for (String comando : ELENCO_COMANDI)
            mostraMessaggio(comando + "  ");
        mostraMessaggio("");
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
        return "aiuto";
    }

    private void mostraMessaggio(String messaggio) {
        if (this.io != null)
            this.io.mostraMessaggio(messaggio);
    }
}
