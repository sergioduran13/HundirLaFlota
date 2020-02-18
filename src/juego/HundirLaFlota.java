package juego;

import java.util.Scanner;
import metodo.*;

public class HundirLaFlota {
	static Scanner tec = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;
		do {
			opcion = opcionMenu();
			switch (opcion) {
			case 1:
				System.out.println("\nNUEVA PARTIDA");
				String jugador1 = nombreJugador(1).toUpperCase();
				String jugador2 = nombreJugador(2).toUpperCase();
				System.out.println("\n" + jugador1 + " VS " + jugador2);
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				nuevaPartida(jugador1, jugador2);
				break;

			case 2:
				System.out.println("\nREGLAS\n");
				reglas();
				break;
			case 3:
				System.out.println("                                  )___(");
				System.out.println("                           _______/__/_");
				System.out.println("                  ___     /===========|   ___");
				System.out.println(" ____       __   [\\\\\\]___/____________|__[///]   __");
				System.out.println(" \\   \\_____[\\\\]__/___________________________\\__[//]___");
				System.out.println("  \\40A                CERRANDO EL JUEGO                   |");
				System.out.println("   \\                 ¡GRACIAS POR JUGAR!                  |");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				break;
			case 366:
				System.out.println();
				System.out.println("                                       |__");
				System.out.println("                                       |\\/");
				System.out.println("                                       ---");
				System.out.println("                                       / | [");
				System.out.println("                                !      | |||");
				System.out.println("                          +  +--|    |--|--|_ |-");
				System.out.println("                       { /|__|  |/\\__|  |--- |||__/");
				System.out.println("                      +---------------___[}-_===_.'____                 /\\");
				System.out.println("                  ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _");
				System.out.println("   __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7");
				System.out.println("  \\                                                                     1º-DAM/");
				System.out.println("   \\                               HECHO POR                               |");
				System.out.println("    \\                    Sergio Duran y Alvaro Sobrino                     |");
				System.out
						.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out
						.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

				break;
			}
		} while (opcion != 3);
	}

	public static int opcionMenu() {
		int opcion = 0;

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~HUNDIR LA FLOTA~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		do {
			System.out.println("\n1. Nueva partida\n2. Reglas\n3. Salir");
			System.out.println("Introduce opcion: ");
			opcion = LeerEntero.numeroEntero();
			if (opcion != 366) {
				if (opcion > 3 || opcion <= 0) {
					System.out.println("Numero de opcion no valido.");
				}
			}
		} while (opcion <= 0 || opcion > 3 && opcion != 366);
		return opcion;
	}

	public static String nombreJugador(int a) {

		System.out.println("Introduzca nombre jugador " + a + ":");
		return tec.next();

	}

	public static void nuevaPartida(String jugador1, String jugador2) {

		int[][] tablero1 = new int[10][10];
		int[][] tablero2 = new int[10][10];
		String[][] tableroJuego1 = tableroBonito(tablero1);
		String[][] tableroJuego2 = tableroBonito(tablero2);
		int hp1 = 19, hp2 = 19, turno = 0;

		// Barcos
		int[] barcos = { 5, 4, 4, 3, 3 };

		Juego.mostrarTableroJugador(tableroJuego1, jugador1);
		tablero1 = rellenarBarco(jugador1, barcos, tablero1);
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		Juego.mostrarTableroJugador(tableroJuego2, jugador2);
		tablero2 = rellenarBarco(jugador2, barcos, tablero2);
		String[][] tableroBonito1 = tableroBonito(tablero1);
		String[][] tableroBonito2 = tableroBonito(tablero2);

		do {
			if (hp1 > 0) {
				// Turno J1
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				Juego.mostrarTableroDeJuego(tableroJuego1, tableroBonito1, jugador1);
				Juego.mostrarSalud(jugador1, jugador2, hp1, hp2, turno);
				hp2 = Juego.juego(tableroJuego1, tableroBonito2, hp2, jugador1, jugador2);
			}

			if (hp2 > 0) {
				// Turno J2
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				Juego.mostrarTableroDeJuego(tableroJuego2, tableroBonito2, jugador2);
				Juego.mostrarSalud(jugador1, jugador2, hp1, hp2, turno);
				hp1 = Juego.juego(tableroJuego2, tableroBonito1, hp1, jugador1, jugador2);
			}

			
			turno++;
		} while (hp1 > 0 && hp2 > 0);

		turno--;

		Juego.mostrarSalud(jugador1, jugador2, hp1, hp2, turno);
		System.out.println();

		if (hp1 == 0) {
			System.out.println("                                  )___(");
			System.out.println("                           _______/__/_");
			System.out.println("                  ___     /===========|   ___");
			System.out.println(" ____       __   [\\\\\\]___/____________|__[///]   __");
			System.out.println(" \\   \\_____[\\\\]__/___________________________\\__[//]___");
			System.out.println("  \\40A                HA GANADO " + jugador2);
			System.out.println("   \\                                                  /");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		} else {
			System.out.println("                                  )___(");
			System.out.println("                           _______/__/_");
			System.out.println("                  ___     /===========|   ___");
			System.out.println(" ____       __   [\\\\\\]___/____________|__[///]   __");
			System.out.println(" \\   \\_____[\\\\]__/___________________________\\__[//]___");
			System.out.println("  \\40A                HA GANADO " + jugador1);
			System.out.println("   \\                                                  /");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
	}

	public static int[][] rellenarBarco(String jugador, int[] barcos, int[][] tablero) {

		for (int i = 0; i < barcos.length; i++) {

			System.out.println("Barco " + (i + 1) + " | Longitud del barco: " + barcos[i]);

			System.out.println("Introduzca posicion X: ");
			int x = LeerEntero.numeroEntero() - 1;
			System.out.println("Introduzca posicion Y: ");
			int y = LeerEntero.numeroEntero() - 1;
			System.out.println("Introduzca orientacion(v/h): ");
			String orientado = LeerOrientacion.leerString();

			try {
				if (orientado.equals("v")) {
					boolean para = false;
					int auxX = x;

					for (int j = 0; j < barcos[i] && para == false; j++, x++) {

						// comprobar si el hueco esta ya ocupado
						if (tablero[x][y] == 1) {
							para = true;
							i--;
						}
					}
					if (para == true) {
						System.out.println("Hueco introducido incorrecto, vuelva a introducir valor nuevo");

					} else {

						// Rellenamos Tablero
						for (int j = 0; j < barcos[i]; j++, auxX++) {
							tablero[auxX][y] = 1;
						}
					}

					// HORIZONTAL
				} else {

					boolean para = false;
					int auxY = y;
					for (int j = 0; j < barcos[i] && para == false; j++, y++) {
						// comprobar si el hueco esta ya ocupado
						if (tablero[x][y] == 1) {
							para = true;

							i--;
						}
					}
					if (para == true) {
						System.out.println("Hueco introducido incorrecto, vuelva a introducir valor nuevo");
					} else {

						for (int j = 0; j < barcos[i]; j++, auxY++) {
							tablero[x][auxY] = 1;
						}
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("¡Te has salido del tablero! \n");
				i--;
			}
			System.out.println("");
			Juego.mostrarTableroJugador(tableroBonito(tablero), jugador);

		}
		return tablero;

	}

	public static void reglas() {
		System.out.println(
				"El juego consiste en hundir la flota del contrincante. Para ello, debe colocar \nsu propia flota de forma estratégica y encontrar y "
						+ "hundir con los disparos la flota contraria. \n\nPrimero se pedira la colocacion de los barcos del jugador 1 y luego jugador 2. \nCada jugador "
						+ "dispone de 5 barcos de tamaños distintos(1 x 5huecos, 2 x 4huecos. 2 x 3huecos). \n\nHay que introducir eje X(FILAS) y luego eje Y(COLUMNA) de la primera posición del barco, indicando \nluego la posicion v(vertical) o h(horizontal)"
						+ "\n\nUna vez introducidos todos los barcos empezara la partida. Se muestran dos tableros, el primero \nnos dice donde hemos atacado y el segundo nuestros "
						+ "barcos y como vamos en la partida. Cuando nos \ndañan o dañamos un barco se nos indicara con una X, si fallamos el tiro con un O."
						+ "\n\nSi repetimos un disparo donde ya hemos disparado perderemos el turno."
						+ "\n\nDurante la partida sabremos las vidas de cada jugador, gana el primero que deje a 0 al contrincante."
						+ "\n\nHay un Easter EGG en el menu.(pista: año bisiesto).\n");
	}

	public static String[][] tableroBonito(int[][] tablero) {
		//Pasamos el tablero[] de int a String. Este será el que vea el usuario. El de int es para trabajar de forma interna
		String[][] tableroBonito = new String[10][10];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == 0) {
					tableroBonito[i][j] = "~";
				} else {
					tableroBonito[i][j] = "B";
				}
			}
		}
		return tableroBonito;
	}
}
