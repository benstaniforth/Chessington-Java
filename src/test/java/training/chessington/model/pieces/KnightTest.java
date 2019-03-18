package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class KnightTest {

    @Test
    public void knightCanMove () {

        // Arrange
        Board board = Board.empty();
        Game game = new Game(board);

        Piece whiteKnight = new Knight(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(3, 3);
        board.placePiece(whiteCoords, whiteKnight);

        Piece blackKnight = new Knight(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(5, 5);
        board.placePiece(blackCoords, whiteKnight);

        // Act
        List<Move> whiteMoves = whiteKnight.getAllowedMoves(whiteCoords, board, game);
        List<Move> blackMoves = blackKnight.getAllowedMoves(blackCoords, board, game);

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
        Game game = new Game(board);

        Piece whiteKnight = new Knight(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(1, 1);
        board.placePiece(whiteCoords, whiteKnight);

        Piece blackKnight = new Knight(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(7, 7);
        board.placePiece(blackCoords, blackKnight);

        // Act
        List<Move> whiteMoves = whiteKnight.getAllowedMoves(whiteCoords, board, game);
        List<Move> blackMoves = blackKnight.getAllowedMoves(blackCoords, board, game);

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
        Game game = new Game(board);

        Piece whiteKnight = new Knight(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(2, 2);
        board.placePiece(whiteCoords, whiteKnight);

        Piece whiteKnight2 = new Knight(PlayerColour.WHITE);
        Coordinates whiteCoords2 = new Coordinates(3, 4);
        board.placePiece(whiteCoords2, whiteKnight);


        // Act
        List<Move> whiteMoves = whiteKnight.getAllowedMoves(whiteCoords, board, game);
        List<Move> whiteMoves2 = whiteKnight2.getAllowedMoves(whiteCoords2, board, game);

        // Assert
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(1, 2)));
        assertThat(whiteMoves2).doesNotContain(new Move(whiteCoords2, whiteCoords2.plus(-1, -2)));

    }


}
