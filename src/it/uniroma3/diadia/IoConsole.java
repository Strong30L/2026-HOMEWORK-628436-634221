
/**
 * Classe che gestisce input ed output
 *
 * @author Filippo , Andrea
 *          
 * @version base
 */

package it.uniroma3.diadia;
import java.util.Scanner;
	
public class IoConsole {
	public void mostraMessaggio(String msg) {
	System.out.println(msg);
	}
	public String leggiRiga() {
	Scanner scannerDiLinee = new Scanner(System.in);
	String riga = scannerDiLinee.nextLine();
	//scannerDiLinee.close();
	return riga;
	}
	}

