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

        allowedMoves.addAll(straightMoves(from, board, 1, 0));
        allowedMoves.addAll(straightMoves(from, board, -1, 0));
        allowedMoves.addAll(straightMoves(from, board, 0, 1));
        allowedMoves.addAll(straightMoves(from, board, 0, -1));

        return allowedMoves;
    }



}
