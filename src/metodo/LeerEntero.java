package metodo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerEntero {
	static Scanner tec = new Scanner(System.in);

	public static int numeroEntero() {
		boolean esEntero = false;
		int entero = 0;

		do {
			try {
				entero = tec.nextInt();
				esEntero = true;
			} catch (InputMismatchException e) {
				System.out.println("Error. Vuelve a introducir numero:\n");
				tec.nextLine();

			}
		} while (!esEntero);

		return entero;
	}
}
