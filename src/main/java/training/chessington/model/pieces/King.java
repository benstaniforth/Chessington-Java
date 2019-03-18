package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board, Game game) {
        return kingMoves(from, board);
    }
}
