package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    public static final String MESSAGGIO_STANZA_BUIA = "qui c'\u00e8 buio pesto";

    private String attrezzoPerVedere;

    public StanzaBuia(String nome, String attrezzoPerVedere) {
        super(nome);
        this.attrezzoPerVedere = attrezzoPerVedere;
    }

    @Override
    public String getDescrizione() {
        if (this.hasAttrezzo(this.attrezzoPerVedere))
            return super.getDescrizione();
        return MESSAGGIO_STANZA_BUIA;
    }
}
