package training.chessington.model.pieces;

import javafx.scene.input.PickResult;
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
        Coordinates whiteCoords = new Coordinates(3, 3);
        board.placePiece(whiteCoords, whiteKnight);

        Piece blackKnight = new Knight(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(5, 5);
        board.placePiece(blackCoords, whiteKnight);

        // Act
        List<Move> whiteMoves = whiteKnight.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackKnight.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-1, -2)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(1, -2)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-2, 1)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-2, -1)));

        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-1, -2)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(1, -2)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-2, 1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-2, -1)));

    }

    @Test
    public void knightDoesNotMoveOffBoard () {

        // Arrange
        Board board = Board.empty();

        Piece whiteKnight = new Knight(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(1, 1);
        board.placePiece(whiteCoords, whiteKnight);

        Piece blackKnight = new Knight(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(7, 7);
        board.placePiece(blackCoords, blackKnight);

        // Act
        List<Move> whiteMoves = whiteKnight.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackKnight.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(-2, -1)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(-1, -2)));
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(2, 1)));
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(1, 2)));

    }

    @Test
    public void knightCannotMoveOntoFriendlySpace () {

        // Arrange
        Board board = Board.empty();

        Piece whiteKnight = new Knight(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(2, 2);
        board.placePiece(whiteCoords, whiteKnight);

        Piece whiteKnight2 = new Knight(PlayerColour.WHITE);
        Coordinates whiteCoords2 = new Coordinates(3, 4);
        board.placePiece(whiteCoords2, whiteKnight);


        // Act
        List<Move> whiteMoves = whiteKnight.getAllowedMoves(whiteCoords, board);
        List<Move> whiteMoves2 = whiteKnight2.getAllowedMoves(whiteCoords2, board);

        // Assert
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(1, 2)));
        assertThat(whiteMoves2).doesNotContain(new Move(whiteCoords2, whiteCoords2.plus(-1, -2)));

    }


}
