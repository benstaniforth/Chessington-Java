package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {

    @Test
    public void knightCanMove () {

        // Arrange
        Board board = Board.empty();

        Piece whiteKnight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, whiteKnight);

        // Act
        List<Move> moves = whiteKnight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).containsExactlyInAnyOrder(new Move(coords, coords.plus(-1, -2)));
        assertThat(moves).containsExactlyInAnyOrder(new Move(coords, coords.plus(1, -2)));
        assertThat(moves).containsExactlyInAnyOrder(new Move(coords, coords.plus(-2, 1)));
        assertThat(moves).containsExactlyInAnyOrder(new Move(coords, coords.plus(-2, -1)));

    }

    @Test
    public void knightDoesNotMoveOffBoard () {

        // Arrange
        Board board = Board.empty();

        Piece whiteKnight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(1, 1);
        board.placePiece(coords, whiteKnight);

        // Act
        List<Move> moves = whiteKnight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, -2)));

    }


}
