package chess.pieces;

import boradgame.Board;
import boradgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position position = new Position(0, 0);

		// above
		position.setValues(this.position.getRow() - 1, this.position.getColumn());
		if (getBoard().positionExistis(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// below
		position.setValues(this.position.getRow() + 1, this.position.getColumn());
		if (getBoard().positionExistis(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// left
		position.setValues(this.position.getRow(), this.position.getColumn() - 1);
		if (getBoard().positionExistis(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		// right
		position.setValues(this.position.getRow(), this.position.getColumn() + 1);
		if (getBoard().positionExistis(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		// nw
		position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
		if (getBoard().positionExistis(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		// ne
		position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
		if (getBoard().positionExistis(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		// sw
		position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
		if (getBoard().positionExistis(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		// se
		position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
		if (getBoard().positionExistis(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		return mat;

	}

}
