package applicaion;

import java.util.Locale;
import java.util.Scanner;

import entities.Champion;

public class Fighting {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String name = "";
		int life = 0, attack = 0, armor = 0, turns, totalTurns;

		Champion A, B;
		A = new Champion(name, life, attack, armor);
		B = new Champion(name, life, attack, armor);

		System.out.println("Digite os dados do primeiro campeão: ");
		System.out.print("Name: ");
		name = sc.nextLine();
		A.setName(name);
		System.out.print("Vida inicial: ");
		life = sc.nextInt();
		A.setLife(life);
		System.out.print("Ataque: ");
		attack = sc.nextInt();
		A.setAttack(attack);
		System.out.print("Armadura: ");
		armor = sc.nextInt();
		A.setArmor(armor);

		sc.nextLine(); // Limpando o buffer

		System.out.println("\nDigite os dados do segundo campeão: ");
		System.out.print("Name: ");
		name = sc.nextLine();
		B.setName(name);
		System.out.print("Vida inicial: ");
		life = sc.nextInt();
		B.setLife(life);
		System.out.print("Ataque: ");
		attack = sc.nextInt();
		B.setAttack(attack);
		System.out.print("Armadura: ");
		armor = sc.nextInt();
		B.setArmor(armor);

		System.out.print("\nQuantos turnos você deseja executar? ");
		totalTurns = sc.nextInt();
		turns = totalTurns; // Guardar o valor original dos turnos para calcular o número do turno

		for (int turn = 1; turn <= totalTurns && A.isAlive() && B.isAlive(); turn++) {
			System.out.println("\nResultado do turno: " + turn);

			// Champion B ataca Champion A
			A.takeDamage(B.getAttack());
			System.out.println(A.status());

			if (!A.isAlive()) {
				// Imprime o status final de B, mesmo se A morrer
				System.out.println(B.status());
				break;
			}

			// Champion A ataca Champion B
			B.takeDamage(A.getAttack());
			System.out.println(B.status());
		}
		System.out.print("\nFIM DO COMBATE");

		sc.close();
	}
}
