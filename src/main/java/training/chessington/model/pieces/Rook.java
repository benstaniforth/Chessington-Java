package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board, Game game) {

        List<Move> allowedMoves = new ArrayList<>();

        allowedMoves.addAll(straightMoves(from, board, 1, 0));
        allowedMoves.addAll(straightMoves(from, board, -1, 0));
        allowedMoves.addAll(straightMoves(from, board, 0, 1));
        allowedMoves.addAll(straightMoves(from, board, 0, -1));

        return allowedMoves;
    }



}
