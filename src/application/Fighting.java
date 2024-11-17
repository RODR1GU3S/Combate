package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Champion;

public class Fighting {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Leitura dos dados do primeiro campeão
        System.out.println("Digite os dados do primeiro campeão: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life = sc.nextInt();
        System.out.print("Ataque: ");
        int attack = sc.nextInt();
        System.out.print("Armadura: ");
        int armor = sc.nextInt();
        Champion A = new Champion(name, life, attack, armor);

        sc.nextLine(); // Limpar o buffer

        // Leitura dos dados do segundo campeão
        System.out.println("\nDigite os dados do segundo campeão: ");
        System.out.print("Nome: ");
        name = sc.nextLine();
        System.out.print("Vida inicial: ");
        life = sc.nextInt();
        System.out.print("Ataque: ");
        attack = sc.nextInt();
        System.out.print("Armadura: ");
        armor = sc.nextInt();
        Champion B = new Champion(name, life, attack, armor);

        System.out.print("\nQuantos turnos você deseja executar? ");
        int totalTurns = sc.nextInt();

        // Executando os turnos
        for (int turn = 1; turn <= totalTurns && A.isAlive() && B.isAlive(); turn++) {
            System.out.println("\nResultado do turno: " + turn);

            // Champion B ataca Champion A
            A.takeDamage(B.getAttack());
            System.out.println(A.status());

            // Champion A ataca Champion B
            B.takeDamage(A.getAttack());
            System.out.println(B.status());
        }

        System.out.print("\nFIM DO COMBATE");

        sc.close();
    }
}
