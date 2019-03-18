package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board, Game game) {

        List<Move> allowedMoves = new ArrayList<>();

        if (moveIsAllowed(from.plus(-2, -1), board)) {
            allowedMoves.add(new Move(from, from.plus(-2, -1)));
        }
        if (moveIsAllowed(from.plus(-2, 1), board)) {
            allowedMoves.add(new Move(from, from.plus(-2, 1)));
        }
        if (moveIsAllowed(from.plus(-1, -2), board)) {
            allowedMoves.add(new Move(from, from.plus(-1, -2)));
        }
        if (moveIsAllowed(from.plus(-1, 2), board)) {
            allowedMoves.add(new Move(from, from.plus(-1, 2)));
        }
        if (moveIsAllowed(from.plus(1, -2), board)) {
            allowedMoves.add(new Move(from, from.plus(1, -2)));
        }
        if (moveIsAllowed(from.plus(1, 2), board)) {
            allowedMoves.add(new Move(from, from.plus(1, 2)));
        }
        if (moveIsAllowed(from.plus(2, -1), board)) {
            allowedMoves.add(new Move(from, from.plus(2, -1)));
        }
        if (moveIsAllowed(from.plus(2, 1), board)) {
            allowedMoves.add(new Move(from, from.plus(2, 1)));
        }

        return allowedMoves;

    }


}
