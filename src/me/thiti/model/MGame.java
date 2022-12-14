package me.thiti.model;

public class MGame {
    private static final int N = 10;

    private int roundCat;
    private Die[] dice;
    private Board board;
    private Player[] players;

    public MGame(String[] playerNames, int playerCount) {
        roundCat = 0;

        dice = new Die[2];
        dice[0] = new Die();
        dice[1] = new Die();

        board = new Board();

        Player[] players = createPlayers(playerNames, playerCount);
        initializePlayers(players);
    }

    private Player[] createPlayers(String[] playerNames, int playerCount) {
        Player[] players = new Player[playerCount];
        for (int i = 0; i < playerCount; ++i) {
            players[i] = new Player(playerNames[i]);
        }

        return players;
    }

    private void initializePlayers(Player[] players) {
        this.players = players;
        for (Player player : players) {
            player.setBoard(this.board);
            player.setDice(this.dice);
            player.setLocation(board.getStartingSquare());
        }
    }

    public void playGame() {
        System.out.println("Starting a game...");

        while (roundCat < N) {
            playRound();
            ++roundCat;
        }

        System.out.println("Game Over");
    }

    private void playRound() {
        System.out.println("Round " + (roundCat + 1));
        for (Player player : players) {
            player.takeTurn();
        }
    }

}
