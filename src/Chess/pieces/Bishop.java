package chess.pieces;

import boradgame.Board;
import boradgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position position = new Position(0, 0);

		// nw
		position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
		while (getBoard().positionExistis(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setValues(position.getRow() -1, position.getColumn() - 1);
		}
		if (getBoard().positionExistis(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// ne
		position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
		while (getBoard().positionExistis(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setValues(position.getRow() - 1, position.getColumn() + 1);
		}
		if (getBoard().positionExistis(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// sw
		position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
		while (getBoard().positionExistis(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setValues(position.getRow() + 1, position.getColumn() + 1);
		}
		if (getBoard().positionExistis(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		// se
		position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
		while (getBoard().positionExistis(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setValues(position.getRow() + 1, position.getColumn() - 1);
		}
		if (getBoard().positionExistis(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		return mat;
	}

}
