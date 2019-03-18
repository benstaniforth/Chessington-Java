package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board, Game game) {

        List<Move> allowedMoves = new ArrayList<>();

        allowedMoves.addAll(straightMoves(from, board, 1, 1));
        allowedMoves.addAll(straightMoves(from, board, -1,-1));
        allowedMoves.addAll(straightMoves(from, board, 1, -1));
        allowedMoves.addAll(straightMoves(from, board, -1, 1));


        return allowedMoves;

    }

}
