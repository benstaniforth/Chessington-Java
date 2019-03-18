package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {

    @Test
    public void kingCanMove () {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 5);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));

    }

    @Test
    public void kingCanTakePiece () {

        // Arrange
        Board board = Board.empty();
        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(2, 2);
        board.placePiece(whiteCoords, whiteKing);

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(2, 3);
        board.placePiece(blackCoords, blackKing);

        // Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(0, 1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(0, 1)));

    }

    @Test
    public void kingCannotTakeFriendly () {

        // Arrange
        Board board = Board.empty();
        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(4, 4);
        board.placePiece(blackCoords, blackKing);

        Piece blackKing2 = new King(PlayerColour.BLACK);
        Coordinates blackCoords2 = new Coordinates(5, 4);
        board.placePiece(blackCoords2, blackKing2);

        // Act
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);
        List<Move> blackMoves2 = blackKing2.getAllowedMoves(blackCoords2, board);

        // Assert
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(1, 0)));
        assertThat(blackMoves2).doesNotContain(new Move(blackCoords2, blackCoords2.plus(-1, 0)));

    }

    @Test
    public void kingDoesNotMoveOffBoard () {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, -1)));
    }

}
