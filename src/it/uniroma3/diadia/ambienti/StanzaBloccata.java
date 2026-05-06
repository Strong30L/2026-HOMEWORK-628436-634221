package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

    private String direzioneBloccata;
    private String attrezzoSbloccante;

    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzoSbloccante = attrezzoSbloccante;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(this.attrezzoSbloccante))
            return this;
        return super.getStanzaAdiacente(direzione);
    }

    @Override
    public String getDescrizione() {
        if (this.hasAttrezzo(this.attrezzoSbloccante))
            return super.getDescrizione();
        return super.getDescrizione() + "\nLa direzione " + this.direzioneBloccata
                + " \u00e8 bloccata: serve " + this.attrezzoSbloccante;
    }
}
