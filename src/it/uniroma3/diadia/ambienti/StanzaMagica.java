package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

    static final private int SOGLIA_MAGICA_DEFAULT = 3;

    private int sogliaMagica;
    private int numeroAttrezziAggiunti;

    public StanzaMagica(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagica(String nome, int sogliaMagica) {
        super(nome);
        this.sogliaMagica = sogliaMagica;
        this.numeroAttrezziAggiunti = 0;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.numeroAttrezziAggiunti++;

        if (this.numeroAttrezziAggiunti > this.sogliaMagica)
            attrezzo = this.modificaAttrezzo(attrezzo);

        return super.addAttrezzo(attrezzo);
    }

    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        String nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse().toString();
        return new Attrezzo(nomeInvertito, attrezzo.getPeso() * 2);
    }
}
