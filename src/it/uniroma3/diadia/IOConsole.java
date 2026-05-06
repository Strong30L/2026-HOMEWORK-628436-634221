package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * Classe che gestisce input ed output da console.
 *
 * @author Filippo , Andrea
 * @version base
 */
public class IOConsole implements IO {

    private Scanner scannerDiLinee;

    public IOConsole() {
        this.scannerDiLinee = new Scanner(System.in);
    }

    @Override
    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }

    @Override
    public String leggiRiga() {
        return this.scannerDiLinee.nextLine();
    }
}
