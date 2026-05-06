package it.uniroma3.diadia;

import java.util.Arrays;

public class IOSimulator implements IO {

    static final private int NUMERO_MASSIMO_MESSAGGI = 100;

    private String[] righeDaLeggere;
    private int indiceRigheDaLeggere;
    private String[] messaggi;
    private int numeroMessaggi;

    public IOSimulator(String[] righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.indiceRigheDaLeggere = 0;
        this.messaggi = new String[NUMERO_MASSIMO_MESSAGGI];
        this.numeroMessaggi = 0;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        if (this.numeroMessaggi == this.messaggi.length)
            this.messaggi = Arrays.copyOf(this.messaggi, this.messaggi.length * 2);
        this.messaggi[this.numeroMessaggi] = messaggio;
        this.numeroMessaggi++;
    }

    @Override
    public String leggiRiga() {
        if (this.indiceRigheDaLeggere < this.righeDaLeggere.length) {
            String riga = this.righeDaLeggere[this.indiceRigheDaLeggere];
            this.indiceRigheDaLeggere++;
            return riga;
        }
        return "fine";
    }

    public String[] getMessaggi() {
        return Arrays.copyOf(this.messaggi, this.numeroMessaggi);
    }

    public String getMessaggio(int indice) {
        if (indice < 0 || indice >= this.numeroMessaggi)
            return null;
        return this.messaggi[indice];
    }

    public int getNumeroMessaggi() {
        return this.numeroMessaggi;
    }
}
