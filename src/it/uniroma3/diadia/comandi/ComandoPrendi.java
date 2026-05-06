package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

    private String nomeAttrezzo;
    private IO io;

    public ComandoPrendi() {
    }

    public ComandoPrendi(IO io) {
        this.io = io;
    }

    @Override
    public void esegui(Partita partita) {
        if (this.nomeAttrezzo == null) {
            mostraMessaggio("Quale attrezzo vuoi prendere?");
            return;
        }

        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(this.nomeAttrezzo);

        if (attrezzo == null) {
            mostraMessaggio("Attrezzo non presente nella stanza.");
            return;
        }

        boolean aggiunto = partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        if (aggiunto) {
            stanzaCorrente.removeAttrezzo(attrezzo);
            mostraMessaggio("Hai preso: " + this.nomeAttrezzo);
        } else {
            mostraMessaggio("Non riesci a prendere " + this.nomeAttrezzo + ": borsa piena o peso eccessivo.");
        }

        mostraMessaggio(stanzaCorrente.getDescrizione());
        mostraMessaggio(partita.getGiocatore().getBorsa().toString());
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
        return "prendi";
    }

    private void mostraMessaggio(String messaggio) {
        if (this.io != null)
            this.io.mostraMessaggio(messaggio);
    }
}
