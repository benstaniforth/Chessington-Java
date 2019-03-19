package training.chessington.model.pieces;

import training.chessington.model.Move;

public class MoveList {

    private Piece type;
    private Move move;

    public MoveList(Piece type, Move move) {
        this.type = type;
        this.move = move;
    }
}


