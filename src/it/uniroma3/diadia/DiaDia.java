package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 * 
 * @version base
 */
public class DiaDia {

private IoConsole io;
	

    static final private String MESSAGGIO_BENVENUTO =
            "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
          + "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
          + "I locali sono popolati da strani personaggi, alcuni amici, altri... chissa!\n"
          + "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
          + "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
          + "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
          + "Per conoscere le istruzioni usa il comando 'aiuto'.";

    static final private String[] elencoComandi = {
        "vai",
        "aiuto",
        "fine",
        "prendi",
        "posa"
    };

    private Partita partita;

    public DiaDia(IoConsole io) {
        this.partita = new Partita();
        this.io = io;
    }

    public void gioca() {
        String istruzione; 
       
        io.mostraMessaggio(MESSAGGIO_BENVENUTO);
        io.mostraMessaggio("Nome:"+this.partita.getStanzaCorrente().getDescrizione());
        do
            istruzione = io.leggiRiga();
        while(!processaIstruzione(istruzione));
    }

    private boolean processaIstruzione(String istruzione) {
        Comando comando = new Comando(istruzione);

        if (comando.getNome() == null)
            return false;

        if (comando.getNome().equals("fine")) {
            fine();
            return true;
        }
        else if (comando.getNome().equals("vai")) {
            vai(comando.getParametro());
        }
        else if (comando.getNome().equals("aiuto")) {
            aiuto();
        }
        else if (comando.getNome().equals("prendi")) {
            prendi(comando.getParametro());
        }
        else if (comando.getNome().equals("posa")) {
            posa(comando.getParametro());
        }
        else {
           io.mostraMessaggio("Comando Sconosciuto");
        }

        if (this.partita.vinta()) {
           io.mostraMessaggio("Hai vinto!");
            return true;
        }

        if (this.partita.isFinita()) {
            io.mostraMessaggio("CFU esauriti!");
            return true;
        }

        return false;
    }

    private void aiuto() {
    	io.mostraMessaggio("comandi disponibili:");
        for (int i = 0; i < elencoComandi.length; i++) {
           io.mostraMessaggio(elencoComandi[i] + "  ");
        }
  
        
        io.mostraMessaggio("");
    }

    private void vai(String direzione) {
        if (direzione == null) {
            io.mostraMessaggio("Dove vuoi andare?");
            return;
        }

        Stanza prossimaStanza = null;
        prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
        
        if (prossimaStanza == null) {
            io.mostraMessaggio("Direzione inesistente");
        } else {
            this.partita.setStanzaCorrente(prossimaStanza);
            this.partita.getGiocatore().setCfu(this.partita.getGiocatore().getCfu() - 1);
        }

        io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
        io.mostraMessaggio("CFU rimasti: " + this.partita.getGiocatore().getCfu());
    }

    private void prendi(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
        	 io.mostraMessaggio("Quale attrezzo vuoi prendere?");
            return;
        }

        Stanza stanzaCorrente = this.partita.getStanzaCorrente();
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);

        if (attrezzo == null) {
        	 io.mostraMessaggio("Attrezzo non presente nella stanza.");
            return;
        }

        boolean aggiunto = this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        if (aggiunto) {
            stanzaCorrente.removeAttrezzo(attrezzo);
            io.mostraMessaggio("Hai preso: " + nomeAttrezzo);
        } else {
        	 io.mostraMessaggio("Non riesci a prendere " + nomeAttrezzo + ": borsa piena o peso eccessivo.");
        }

        io.mostraMessaggio(stanzaCorrente.getDescrizione());
        io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
    }

    private void posa(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
        	 io.mostraMessaggio("Quale attrezzo vuoi posare?");
            return;
        }

        Borsa borsa = this.partita.getGiocatore().getBorsa();
        Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);

        if (attrezzo == null) {
        	 io.mostraMessaggio("Non hai questo attrezzo nella borsa.");
            return;
        }

        this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
        io.mostraMessaggio("Hai posato: " + nomeAttrezzo);

        io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
        io.mostraMessaggio(borsa.toString());
    }

    private void fine() {
    	 io.mostraMessaggio("Grazie di aver giocato!");
        this.partita.setFinita();
    }

    public static void main(String[] args) {
    
    	IoConsole io = new IoConsole();  
        DiaDia gioco = new DiaDia(io); 
        gioco.gioca();
    }
}