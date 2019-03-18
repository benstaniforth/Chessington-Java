package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }


    public boolean moveIsInBounds(Coordinates to, Board board) {
        return (to.getCol() >= 0 && to.getCol() <= 7 && to.getRow() >= 0 && to.getRow() <= 7);
    }

    public boolean spaceIsEmpty(Coordinates to, Board board) {

        return board.get(to) == null;
    }

    public boolean spaceContainsFriendly(Coordinates to, Board board) {

        return board.get(to).getColour().equals(colour);

    }

    public boolean spaceContainsEnemyThatCanBeTaken(Coordinates to, Board board) {

        return !board.get(to).getColour().equals(colour);

    }

    public boolean moveIsAllowed(Coordinates to, Board board) {
        if (!(to.getCol() >= 0 && to.getCol() <= 7 && to.getRow() >= 0 && to.getRow() <= 7)) {
            return false;
        }
        return board.get(to) == null || !board.get(to).getColour().equals(colour);
    }

    public List<Move> straightMoves(Coordinates from, Board board, int rowChange, int colChange) {

        List<Move> straightMoves = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            Coordinates to = from.plus(rowChange * i, colChange * i);

            if (moveIsInBounds(to, board)) {
                if (spaceIsEmpty(to, board)) {
                    straightMoves.add(new Move(from, to));
                } else if (spaceContainsEnemyThatCanBeTaken(to, board)) {
                    straightMoves.add(new Move(from, to));
                    break;
                } else if (spaceContainsFriendly(to, board)) {
                    break;
                }
            } else {
                break;
            }
        }

        return straightMoves;
    }

}
