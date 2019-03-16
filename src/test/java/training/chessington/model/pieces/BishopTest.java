package training.chessington.model.pieces;

import javafx.beans.binding.When;
import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import javax.swing.*;
import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {

    @Test
    public void bishopCanMove () {

        // Arrange
        Board board = Board.empty();

        Piece whiteBishop = new Bishop(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(2, 2);
        board.placePiece(whiteCoords, whiteBishop);

        Piece blackBishop = new Bishop(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(4, 5);
        board.placePiece(blackCoords, blackBishop);

        // Act
        List<Move> whiteMoves = whiteBishop.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackBishop.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(2, 2)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(4, 4)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-1, -1)));

        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-2, -2)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-4, -4)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(1, 1)));


    }

    @Test
    public void bishopDoesNotMoveFromBoard () {

        // Arrange
        Board board = Board.empty();

        Piece whiteBishop = new Bishop(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(1, 1);
        board.placePiece(whiteCoords, whiteBishop);

        // Act
        List<Move> whiteMoves = whiteBishop.getAllowedMoves(whiteCoords, board);

        // Assert
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(-3, -3)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(-3, 3)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(3, -3)));
    }

    @Test
    public void bishopCanTakePiece () {

        // Arrange
        Board board = Board.empty();

        Piece whiteBishop = new Bishop(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(2, 2);
        board.placePiece(whiteCoords, whiteBishop);

        Piece blackBishop = new Bishop(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(5, 5);
        board.placePiece(blackCoords, blackBishop);

        // Act
        List<Move> whiteMoves = whiteBishop.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackBishop.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(3, 3)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-3, -3)));

    }

    @Test
    public void bishopDoesNotTakeFriendlyPiece () {

        // Arrange
        Board board = Board.empty();

        Piece blackBishop = new Bishop(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(2, 5);
        board.placePiece(blackCoords, blackBishop);

        Piece blackBishop2 = new Bishop(PlayerColour.BLACK);
        Coordinates blackCoords2 = new Coordinates(6, 1);
        board.placePiece(blackCoords2, blackBishop2);

        // Act
        List<Move> blackMoves = blackBishop.getAllowedMoves(blackCoords, board);
        List<Move> blackMoves2 = blackBishop2.getAllowedMoves(blackCoords2, board);

        // Assert
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(-4, 4)));
        assertThat(blackMoves2).doesNotContain(new Move(blackCoords2, blackCoords2.plus(4, -4)));


    }

}
