package me.thiti;

public class Player {
    private String name;
    private Piece piece;
    private Die[] dice;
    private Board board;

    public Player(String name) {
        this.name = name;
        this.piece = new Piece();
    }

    public void takeTurn() {
        int[] fv = new int[dice.length];
        int fvTot = 0;
        for (int i = 0 ; i < dice.length ; ++i) {
            dice[i].roll();
            fv[i] = dice[i].getFaceValue();

            fvTot += fv[i];
        }

        Square oldLoc = this.piece.getLocation();
        Square newLoc = this.board.getSquare(oldLoc, fvTot);
        this.setLocation(newLoc);

        System.out.println("Player " + this.name + " rolled " + fvTot + ".");
        System.out.println("Player " + this.name + " is now at sqaure " + newLoc.getName() + ".");
        System.out.println();
    }

    public void setDice(Die[] dice) {
        this.dice = dice;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setLocation(Square square) {
        this.piece.setLocation(square);
    }
}
