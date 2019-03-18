package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> allowedMoves = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            if (moveIsInBounds(from.plus(i, 0), board)) {
                if (spaceIsEmpty(from.plus(i, 0), board)) {
                    allowedMoves.add(new Move(from, from.plus(i, 0)));
                } else if (spaceContainsEnemyThatCanBeTaken(from.plus(i, 0), board)) {
                    allowedMoves.add(new Move(from, from.plus(i, 0)));
                    break;
                } else if (spaceContainsFriendly(from.plus(i, 0), board)) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (moveIsInBounds(from.plus(-i, 0), board)) {
                if (spaceIsEmpty(from.plus(-i, 0), board)) {
                    allowedMoves.add(new Move(from, from.plus(-i, 0)));
                } else if (spaceContainsEnemyThatCanBeTaken(from.plus(-i, 0), board)) {
                    allowedMoves.add(new Move(from, from.plus(-i, 0)));
                    break;
                } else if (spaceContainsFriendly(from.plus(-i, 0), board)) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (moveIsInBounds(from.plus(0, i), board)) {
                if (spaceIsEmpty(from.plus(0, i), board)) {
                    allowedMoves.add(new Move(from, from.plus(0, i)));
                } else if (spaceContainsEnemyThatCanBeTaken(from.plus(0, i), board)) {
                    allowedMoves.add(new Move(from, from.plus(0, i)));
                    break;
                } else if (spaceContainsFriendly(from.plus(0, i), board)) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {

            if (moveIsInBounds(from.plus(0, -i), board)) {
                if (spaceIsEmpty(from.plus(0, -i), board)) {
                    allowedMoves.add(new Move(from, from.plus(0, -i)));
                } else if (spaceContainsEnemyThatCanBeTaken(from.plus(0, -i), board)) {
                    allowedMoves.add(new Move(from, from.plus(0, -i)));
                    break;
                } else if (spaceContainsFriendly(from.plus(0, -i), board)) {
                    break;
                }
            } else {
                break;
            }
        }

        return allowedMoves;
    }



}
