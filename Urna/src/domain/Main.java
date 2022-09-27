package domain;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nulo = 0, candidato, titulo = 0, eleitores = 0, branco = 0;

		Presidente presidente1 = new Presidente();
		presidente1.nome = "Lula";
		Presidente presidente2 = new Presidente();
		presidente2.nome = "Ciro";
		Presidente presidente3 = new Presidente();
		presidente3.nome = "Bolsonaro";

		System.out.println("Insira seu titulo de eleitor ou 0 para encerrar: ");
		titulo = sc.nextInt();

		while (titulo != 0) {

			System.out.println("Vote no seu candidatos");
			System.out.println("1 - Lula ");
			System.out.println("2 - Ciro  ");
			System.out.println("3 - Bolsonaro");
			System.out.println("4 - Nulo ");
			System.out.println("5 - Branco");
			candidato = sc.nextInt();

			switch (candidato) {

			case 1:
				presidente1.votos++;

				break;

			case 2:
				presidente2.votos++;

				break;
			case 3:
				presidente3.votos++;

				break;

			case 4:
				nulo++;

				break;
			case 5:
				branco++;

				break;
			}

			eleitores++;
			System.out.println("Insira seu titulo de eleitor ou 0 para encerrar: ");
			titulo = sc.nextInt();
		}

		System.out.println("Número de eleitores participantes: " + eleitores);
		System.out.println(presidente1);
		System.out.println(presidente2);
		System.out.println(presidente3);
		System.out.println("Votos Nulo: " + nulo);
		System.out.println("Votos em Branco" + branco);

		System.out.println("A porcentagem de votos de Lula foi: " + porcentagem(presidente1.votos, eleitores));

		System.out.println("A porcentagem de votos de Ciro foi: " + porcentagem(presidente2.votos, eleitores));

		System.out.println("A porcentagem de votos de Bolsonaro foi: " + porcentagem(presidente3.votos, eleitores));

		System.out.println("A porcentagem de votos Nulos foi: " + porcentagem(nulo, eleitores));

		System.out.println("A porcentagem de votos em branco foi: " + porcentagem(branco, eleitores));

		if (presidente1.votos > presidente2.votos && presidente1.votos > presidente3.votos
				&& porcentagem(presidente1.votos, eleitores) > 50
				&& porcentagem(presidente1.votos, eleitores) > porcentagem(nulo, eleitores)) {
			System.out.println("Lula venceu a eleição com: " + porcentagem(presidente1.votos, eleitores) + "dos votos");
		} else if (presidente3.votos > presidente1.votos && presidente3.votos > presidente2.votos
				&& porcentagem(presidente3.votos, eleitores) > 50
				&& porcentagem(presidente3.votos, eleitores) > porcentagem(nulo, eleitores)) {
			System.out.println(
					"Bolsonaro venceu a eleição com: " + porcentagem(presidente3.votos, eleitores) + "dos votos");
		} else if (presidente2.votos > presidente1.votos && presidente2.votos > presidente3.votos
				&& porcentagem(presidente2.votos, eleitores) > 50
				&& porcentagem(presidente2.votos, eleitores) > porcentagem(nulo, eleitores)) {
			System.out.println("Ciro venceu a eleicao com " + porcentagem(presidente2.votos, eleitores) + "dos votos");
		} else if (porcentagem(nulo, eleitores) > porcentagem(presidente1.votos, eleitores)
				&& porcentagem(nulo, eleitores) > porcentagem(presidente1.votos, eleitores)
				&& porcentagem(nulo, eleitores) > porcentagem(presidente2.votos, eleitores)) {
			System.out.println(
					"A porcentagem de votos nulos ou brancos foi maior que o candidato mais votado, haverá nova eleicao");
		} else {
			System.out.println("Irá se iniciar o segundo turno:");
			segundoTurno(presidente1, presidente2, presidente3);
		}

	}

	public static double porcentagem(int votos, int contador) {
		return (votos * 100) / contador;

	}

	public static int max(int x, int y, int z) {
		int aux;
		if (x > y && x > z) {
			aux = x;
		} else if (y > z) {
			aux = y;
		} else {
			aux = z;
		}
		return aux;
	}

	public static void segundoTurno(Presidente presidente1, Presidente presidente2, Presidente presidente3) {
		if (presidente1.votos >= presidente2.votos && presidente1.votos >= presidente3.votos
				&& presidente3.votos > presidente2.votos) {
			System.out.println("Lula e bolsonaro foram os mais votados e disputarão o segundo turno");
			System.out.println("");
			System.out.println("Insira seu titulo de eleitor ou 0 para encerrar: ");
			Scanner sc = new Scanner(System.in);
			int titulo = sc.nextInt();
			presidente1.votos = 0;
			presidente2.votos = 0;
			presidente3.votos = 0;
			int contadorGente = 0;
			while (titulo != 0) {

				System.out.println("Vote no seu candidatos");
				System.out.println("1 - Lula ");
				System.out.println("3 - Bolsonaro");
				int candidato = sc.nextInt();

				switch (candidato) {

				case 1:
					presidente1.votos++;

					break;

				case 3:
					presidente3.votos++;

					break;
				}

				contadorGente++;
				System.out.println("Insira seu titulo de eleitor ou 0 para encerrar: ");
				titulo = sc.nextInt();
			}
			System.out.println("A porcentagem de votos de Lula foi: " + porcentagem(presidente1.votos, contadorGente));
			System.out.println(
					"A porcentagem de votos de Bolsonaro foi: " + porcentagem(presidente3.votos, contadorGente));
			if (presidente1.votos > presidente3.votos) {
				System.out.println("Lula ganhou o segundo turno");
			} else {
				System.out.println("Bolsonaro ganhou o segundo turno");
			}

		} else if (presidente3.votos >= presidente2.votos && presidente1.votos < presidente2.votos) {
			System.out.println("Bolsonaro e Ciro foram os mais votado disputarão o segundo turno");
			System.out.println("");
			System.out.println("Insira seu titulo de eleitor ou 0 para encerrar: ");
			Scanner sc = new Scanner(System.in);
			int titulo = sc.nextInt();
			presidente1.votos = 0;
			presidente2.votos = 0;
			presidente3.votos = 0;
			int contadorGente = 0;
			while (titulo != 0) {

				System.out.println("Vote no seu candidatos");
				System.out.println("2 - Ciro ");
				System.out.println("3 - Bolsonaro");
				int candidato = sc.nextInt();

				switch (candidato) {

				case 2:
					presidente2.votos++;

					break;

				case 3:
					presidente3.votos++;

					break;
				}

				contadorGente++;
				System.out.println("Insira seu titulo de eleitor ou 0 para encerrar: ");
				titulo = sc.nextInt();
			}
			System.out.println(
					"A porcentagem de votos de Bolsoanro foi: " + porcentagem(presidente3.votos, contadorGente));
			System.out.println("A porcentagem de votos de Ciro foi: " + porcentagem(presidente2.votos, contadorGente));
			if (presidente3.votos > presidente2.votos) {
				System.out.println("Bolsonaro ganhou o segundo turno");
			} else {
				System.out.println("Ciro ganhou o segundo turno");
			}

		} else {
			System.out.println("Ciro e lula foram os mais votado irão disputar o segundo turno");
			System.out.println("Insira seu titulo de eleitor ou 0 para encerrar: ");
			Scanner sc = new Scanner(System.in);
			int titulo = sc.nextInt();
			presidente1.votos=0;
			presidente2.votos=0;
			presidente3.votos=0;
			int contadorGente =0;
			while (titulo != 0) {

				System.out.println("Vote no seu candidatos");
				System.out.println("1 - Lula ");
				System.out.println("2 - Ciro");
				int candidato = sc.nextInt();

				switch (candidato) {

				case 1:
					presidente1.votos++;

					break;

				case 2:
					presidente2.votos++;

					break;
				}

				contadorGente++;
				System.out.println("Insira seu titulo de eleitor ou 0 para encerrar: ");
				titulo = sc.nextInt();
			}
			System.out.println("A porcentagem de votos de Lula foi: " + porcentagem(presidente1.votos, contadorGente));
			System.out.println("A porcentagem de votos de Ciro foi: " + porcentagem(presidente2.votos, contadorGente));
			if(presidente1.votos > presidente2.votos) {
				System.out.println("Lula ganhou o segundo turno");
			}else {
				System.out.println("Ciro ganhou o segundo turno");
			}
		}
	}
}
