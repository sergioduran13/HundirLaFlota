package metodo;

import java.util.Scanner;

public class LeerOrientacion {
	static Scanner tec = new Scanner(System.in);

	public static String leerString() {
		boolean encontrado = false;
		String texto = "";
		do {
			texto = tec.next().toLowerCase();
			if (texto.equals("h") || texto.equals("v"))
				encontrado = true;
			else
				System.out.println("Error. Vuelve a introducirlo:");

		} while (!encontrado);
		return texto;
	}
}
