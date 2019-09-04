package chess;

import boradgame.Board;
import boradgame.Piece;
import boradgame.Position;

public abstract class ChessPiece extends Piece {
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece != null && piece.getColor() != color;
	}

}
