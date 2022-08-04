package me.thiti;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerCount;
        String[] playerNames;

        System.out.println("Welcome to the Monopoly Game.");

        while (true) {
            System.out.print("Please enter amount of players (2-8): ");
            playerCount = scanner.nextInt();

            if (playerCount >= 2 && playerCount <= 8) {
                 break;
            }

            System.out.println("Invalid amount of players. Must be between 2-8.");
        }

        playerNames = new String[playerCount];
        for (int i = 0 ; i < playerCount ; ++i) {
            System.out.print("Enter player #" + (i + 1) + " " + "name: ");
            playerNames[i] = scanner.next();
        }

        Player[] players = new Player[playerCount];
        for (int i = 0 ; i < playerCount ; ++i) {
            players[i] = new Player(playerNames[i]);
        }

        MGame mGame = new MGame(players);
        mGame.playGame();

        scanner.close();
    }
}
