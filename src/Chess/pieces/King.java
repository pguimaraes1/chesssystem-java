package chess.pieces;

import boradgame.Board;
import boradgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
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
		
		//#specialmovecastling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			//#kingside rook
			Position positionT1 = new Position(this.position.getRow(), this.position.getColumn() + 3);
			if(testRookCastling(positionT1)) {
				Position p1 = new Position(this.position.getRow(), this.position.getColumn() + 1);
				Position p2 = new Position(this.position.getRow(), this.position.getColumn() + 2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[this.position.getRow()][this.position.getColumn() + 2] = true;
				}
			}
				//#Queenside rook
			Position positionT2 = new Position(this.position.getRow(), this.position.getColumn() - 4);
			if(testRookCastling(positionT2)) {
				Position p1 = new Position(this.position.getRow(), this.position.getColumn() - 1);
				Position p2 = new Position(this.position.getRow(), this.position.getColumn() - 2);
				Position p3 = new Position(this.position.getRow(), this.position.getColumn() - 3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null  && getBoard().piece(p3) == null) {
					mat[this.position.getRow()][this.position.getColumn() - 2] = true;
				}
			}
		}
		return mat;

	}

}
