package me.thiti.model;

import me.thiti.exception.InvalidSquareFindingException;

public class Board {
    private static final int SQUARE_AMOUNT = 40;

    private final Square[] squares;

    public Board() {
        squares = new Square[SQUARE_AMOUNT];
        for (int i = 0 ; i < squares.length ; ++i) {
            squares[i] = new Square("#" + i);
        }
    }

    public Square getSquare(Square oldLoc, int fvTot) {
        Square result = null;

        try {
            result = squares[addFvTot(findSquareIndex(oldLoc), fvTot)];
        } catch (InvalidSquareFindingException e) {
            e.getStackTrace();
        }

        return result;
    }

    public Square getStartingSquare() {
        return squares[0];
    }

    private int findSquareIndex(Square square) throws InvalidSquareFindingException {
        for (int i = 0 ; i < squares.length ; ++i) {
            if (squares[i] == square) {
                return i;
            }
        }
        throw new InvalidSquareFindingException();
    }

    private int addFvTot(int squareIndex, int fvTot) {
        return (squareIndex + fvTot) % squares.length;
    }
}
