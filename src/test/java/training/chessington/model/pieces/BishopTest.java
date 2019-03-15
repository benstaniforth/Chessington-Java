package training.chessington.model.pieces;

import javafx.beans.binding.When;
import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

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
}
