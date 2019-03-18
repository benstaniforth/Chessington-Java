package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class QueenTest {

    @Test
    public void queenCanMoveStraight () {

        // Arrange
        Board board = Board.empty();
        Game game = new Game(board);

        Piece whiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(3, 3);
        board.placePiece(whiteCoords, whiteQueen);

        // Act
        List<Move> whiteMoves = whiteQueen.getAllowedMoves(whiteCoords, board, game);

        // Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-3, 0)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(3, 0)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(0, -3)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(0, 3)));

    }

    @Test
    public void queenCanMoveDiagonally () {

        // Arrange
        Board board = Board.empty();
        Game game = new Game(board);

        Piece whiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(3, 3);
        board.placePiece(whiteCoords, whiteQueen);

        // Act
        List<Move> whiteMoves = whiteQueen.getAllowedMoves(whiteCoords, board, game);

        // Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-3, -3)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(3, 3)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(3, -3)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-3, 3)));
    }

    @Test
    public void queenDoesNotMoveOffBoard () {

        // Arrange
        Board board = Board.empty();
        Game game = new Game(board);

        Piece whiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(1, 1);
        board.placePiece(whiteCoords, whiteQueen);

        // Act
        List<Move> whiteMoves = whiteQueen.getAllowedMoves(whiteCoords, board, game);

        // Assert
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(-2, -2)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(7, 7)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(-2, 0)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(0, -2)));

    }

    @Test
    public void queenCanTakePiece () {

        // Arrange
        Board board = Board.empty();
        Game game = new Game(board);

        Piece whiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(1, 1);
        board.placePiece(whiteCoords, whiteQueen);

        Piece blackQueen = new Queen(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(4, 4);
        board.placePiece(blackCoords, blackQueen);

        // Act
        List<Move> whiteMoves = whiteQueen.getAllowedMoves(whiteCoords, board, game);
        List<Move> blackMoves = blackQueen.getAllowedMoves(blackCoords, board, game);

        // Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(3, 3)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-3, -3)));


    }

    @Test
    public void queenCannotTakeFriendlyPiece () {

        // Arrange
        Board board = Board.empty();
        Game game = new Game(board);

        Piece whiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(4, 1);
        board.placePiece(whiteCoords, whiteQueen);

        Piece whiteQueen2 = new Queen(PlayerColour.WHITE);
        Coordinates whiteCoords2 = new Coordinates(1, 1);
        board.placePiece(whiteCoords2, whiteQueen2);

        Piece whiteQueen3 = new Queen(PlayerColour.WHITE);
        Coordinates whiteCoords3 = new Coordinates(1, 4);
        board.placePiece(whiteCoords3, whiteQueen3);

        // Act
        List<Move> whiteMoves = whiteQueen.getAllowedMoves(whiteCoords, board, game);

        // Assert
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(-3, 0)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(-3, 3)));

    }



}
