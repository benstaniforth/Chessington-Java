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

        if (colour.equals(PlayerColour.WHITE)) {

            for (int i = 1; i < 8; i++) {
                if (moveIsAllowed(from.plus(i, 0), board)) {
                    allowedMoves.add(new Move(from, from.plus(i, 0)));
                }
                if (moveIsAllowed(from.plus(-i, 0), board)) {
                    allowedMoves.add(new Move(from, from.plus(-i, 0)));
                }
                if (moveIsAllowed(from.plus(0, i), board)){
                    allowedMoves.add(new Move(from, from.plus(0, i)));
                }
                if (moveIsAllowed(from.plus(0, -i), board)) {
                    allowedMoves.add(new Move(from, from.plus(0, -i)));
                }

            }

        }


        if (colour.equals(PlayerColour.BLACK)) {

            for (int i = 1; i < 8; i++) {
                if (moveIsAllowed(from.plus(i, 0), board)) {
                    allowedMoves.add(new Move(from, from.plus(i, 0)));
                }
                if (moveIsAllowed(from.plus(-i, 0), board)) {
                    allowedMoves.add(new Move(from, from.plus(-i, 0)));
                }
                if (moveIsAllowed(from.plus(0, i), board)) {
                    allowedMoves.add(new Move(from, from.plus(0, i)));
                }
                if (moveIsAllowed(from.plus(0, -i), board)) {
                    allowedMoves.add(new Move(from, from.plus(0, -i)));
                }

            }

        }

        return allowedMoves;
    }


    public boolean moveIsAllowed(Coordinates to, Board board) {


        if (to.getCol() >= 0 && to.getCol() <= 7 && to.getRow() >= 0 && to.getRow() <= 7) {
            return true;
        } else
            return false;

    }

}
