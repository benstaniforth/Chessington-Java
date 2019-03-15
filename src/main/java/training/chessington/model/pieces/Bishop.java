package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> allowedMoves = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            if (moveIsInBounds(from.plus(i, i), board)) {
                if (spaceIsEmpty(from.plus(i, i), board)) {
                    allowedMoves.add(new Move(from, from.plus(i, i)));
                } else if (spaceContainsEnemyThatCanBeTaken(from.plus(i, i), board)) {
                    allowedMoves.add(new Move(from, from.plus(i, i)));
                    break;
                } else if (spaceContainsFriendly(from.plus(i, i), board)) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (moveIsInBounds(from.plus(-i, -i), board)) {
                if (spaceIsEmpty(from.plus(-i, -i), board)) {
                    allowedMoves.add(new Move(from, from.plus(-i, -i)));
                } else if (spaceContainsEnemyThatCanBeTaken(from.plus(-i, -i), board)) {
                    allowedMoves.add(new Move(from, from.plus(-i, -i)));
                    break;
                } else if (spaceContainsFriendly(from.plus(-i, -i), board)) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (moveIsInBounds(from.plus(-i, i), board)) {
                if (spaceIsEmpty(from.plus(-i, i), board)) {
                    allowedMoves.add(new Move(from, from.plus(-i, i)));
                } else if (spaceContainsEnemyThatCanBeTaken(from.plus(-i, i), board)) {
                    allowedMoves.add(new Move(from, from.plus(-i, i)));
                    break;
                } else if (spaceContainsFriendly(from.plus(-i, i), board)) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {

            if (moveIsInBounds(from.plus(i, -i), board)) {
                if (spaceIsEmpty(from.plus(i, -i), board)) {
                    allowedMoves.add(new Move(from, from.plus(i, -i)));
                } else if (spaceContainsEnemyThatCanBeTaken(from.plus(i, -i), board)) {
                    allowedMoves.add(new Move(from, from.plus(i, -i)));
                    break;
                } else if (spaceContainsFriendly(from.plus(i, -i), board)) {
                    break;
                }
            } else {
                break;
            }
        }

        return allowedMoves;

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
}
