package metodo;

import java.util.Scanner;

public class Juego {
	public static void mostrarTableroJugador(String[][] tablero, String jugador) {
		System.out.println("Tablero de " + jugador);
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void mostrarTableroDeJuego(String jugada[][], String tablero[][], String jugador) {
		System.out.println("Tablero de " + jugador + "             " + "Barcos de " + jugador);
		for (int i = 0; i < jugada.length; i++) {
			// Muestra la plantilla sobre la que vamos a jugar
			for (int j = 0; j < jugada[i].length; j++) {
				System.out.print(jugada[i][j] + " ");
			}
			System.out.print("             ");
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void mostrarSalud(String jugador1, String jugador2, int hp1, int hp2, int turno) {
		// Mostrar la vida que le queda a los jugadores
		System.out.println("\nTurno: " + turno);
		System.out.println("Vida restante de " + jugador1 + ": " + hp1);
		System.out.println("Vida restante de " + jugador2 + ": " + hp2);
	}

	public static int juego(String jugada[][], String jugador[][], int hp, String jugador1, String jugador2) {
		Scanner tec = new Scanner(System.in);
		int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE;

		System.out.println();
		while (x > 10 || x < 0) {
			// Introducir las coordenadas X
			System.out.println("Introduce la coordenada X: ");
			// Le restamos 1 para que el usuario pueda empezar desde 1
			x = LeerEntero.numeroEntero() - 1;

			if (x > 10 || x < 0)
				System.out.println("Valor incorrecto.");
		}

		while (y > 10 || y < 0) {
			// Introduce las coordenadas Y
			System.out.println("Introduce la coordenada Y: ");
			// Le restamos 1 para que el usuario pueda empezar desde 1
			y = LeerEntero.numeroEntero() - 1;

			if (y > 10 || y < 0)
				System.out.println("Valor incorrecto.");
		}

		// Comprobamos que la posicion nunca ha sido seleccionada
		if (jugada[x][y].equals("X") || jugada[x][y].equals("O")) {
			System.out.println("Ya has elegido esta coordenada.");
		} else {
			// Si la posicion seleccionada es correcta se le resta vida al
			// contrincante y se
			// marca una X en el mapa.
			if (jugador[x][y].equals("B") && !jugada[x][y].equals("X")) {
				hp--;
				jugada[x][y] = "X";
				jugador[x][y] = "X";
				System.out.println("Has acertado");
			}
			// Si la posicion seleccionada es incorrecta se marca una O en el
			// mapa.
			else {
				jugada[x][y] = "O";
				jugador[x][y] = "O";
			}
		}

		return hp;
	}
}
