package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {

    private String nomeAttrezzo;
    private IO io;

    public ComandoPosa() {
    }

    public ComandoPosa(IO io) {
        this.io = io;
    }

    @Override
    public void esegui(Partita partita) {
        if (this.nomeAttrezzo == null) {
            mostraMessaggio("Quale attrezzo vuoi posare?");
            return;
        }

        Borsa borsa = partita.getGiocatore().getBorsa();
        Attrezzo attrezzo = borsa.removeAttrezzo(this.nomeAttrezzo);

        if (attrezzo == null) {
            mostraMessaggio("Non hai questo attrezzo nella borsa.");
            return;
        }

        partita.getStanzaCorrente().addAttrezzo(attrezzo);
        mostraMessaggio("Hai posato: " + this.nomeAttrezzo);

        mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
        mostraMessaggio(borsa.toString());
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }

    @Override
    public String getNome() {
        return "posa";
    }

    private void mostraMessaggio(String messaggio) {
        if (this.io != null)
            this.io.mostraMessaggio(messaggio);
    }
}
