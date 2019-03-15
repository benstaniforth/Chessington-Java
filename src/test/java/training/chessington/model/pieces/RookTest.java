package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {

    @Test
    public void whiteRookCanMoveUpAndDownInColumn() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move (coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(-3, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(-4, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(2, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(3, 0)));

    }


    @Test
    public void blackRookCanMoveUpAndDownInColumn() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move (coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(2, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(3, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(-3, 0)));
        assertThat(moves).contains(new Move (coords, coords.plus(-4, 0)));
    }

    @Test
    public void whiteRookCanMoveLeftAndRightInRow() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move (coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, -2)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, -3)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, -4)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, 3)));

    }

    @Test
    public void blackRookCanMoveLeftAndRightInRow() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move (coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, -2)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, -3)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, -4)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move (coords, coords.plus(0, 3)));

    }

    @Test
    public void blackRookCannotMovePassedAPieceInTheWay () {
        // Arrange
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(2, 2);
        board.placePiece(blackCoords, blackRook);

        Piece blackRook2 = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords2 = new Coordinates(5, 2);
        board.placePiece(blackCoords2, blackRook2);

        Piece blackRook3 = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords3 = new Coordinates(2, 5);
        board.placePiece(blackCoords3, blackRook3);


        // Act
        List<Move> blackMoves = blackRook.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(3, 0)));
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(0, 3)));

    }

    @Test
    public void whiteRookCannotMovePassedAPieceInTheWay () {

        // Arrange
        Board board = Board.empty();

        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(2, 2);
        board.placePiece(whiteCoords, whiteRook);

        Piece whiteRook2 = new Rook(PlayerColour.WHITE);
        Coordinates whiteCoords2 = new Coordinates(5, 2);
        board.placePiece(whiteCoords2, whiteRook2);

        Piece whiteRook3 = new Rook(PlayerColour.WHITE);
        Coordinates whiteCoords3 = new Coordinates(2, 5);
        board.placePiece(whiteCoords3, whiteRook3);

        // Act
        List<Move> whiteMoves = whiteRook.getAllowedMoves(whiteCoords, board);

        // Assert
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(3, 0)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(0, 3)));


    }

}
