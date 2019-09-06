package chess.pieces;

import boradgame.Board;
import boradgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position position = new Position(0, 0);

		// above
		position.setValues(this.position.getRow() - 1, this.position.getColumn());
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setRow(position.getRow() - 1);
		}
		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// left
		position.setValues(this.position.getRow(), this.position.getColumn() - 1);
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setColumn(position.getColumn() - 1);
		}
		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// right
		position.setValues(this.position.getRow(), this.position.getColumn() + 1);
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setColumn(position.getColumn() + 1);
		}
		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		// below
		position.setValues(this.position.getRow() + 1, this.position.getColumn());
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setRow(position.getRow() + 1);
		}
		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		return mat;
	}

}
