package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> allowedMoves = new ArrayList<>();

        if (colour.equals(PlayerColour.WHITE)) {
            if (from.getRow() == 6) {
                allowedMoves.add(new Move(from, from.plus(-2, 0)));
            }
            if ((from.getRow() != 0) && ((board.get(from.plus(-1, 0)) == null))) {
                allowedMoves.add(new Move(from, from.plus(-1, 0)));
            }

        }

        if (colour.equals(PlayerColour.BLACK)) {
            if (from.getRow() == 1) {
                allowedMoves.add(new Move(from, from.plus(2, 0)));
            }
            if ((from.getRow() != 7) && ((board.get(from.plus(1, 0)) == null))) {
                allowedMoves.add(new Move(from, from.plus(1, 0)));
            }
        }


        return allowedMoves;


    }


}
