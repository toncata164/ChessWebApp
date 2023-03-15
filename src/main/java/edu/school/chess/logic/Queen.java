package edu.school.chess.logic;

import java.util.List;

public class Queen extends Figure {
    public Queen(int row, int col, boolean color) {
        this(color, false, row, col);
    }

    public Queen(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
    }

    public boolean move(int row, int column, List<Figure> figureList) {
        if (canMove(row, column, figureList)) {
            setRow(row);
            setColumn(column);
            return true;
        }
        selected = false;
        return false;
    }

    protected boolean canMove(int nextRow, int nextColumn, List<Figure> figureList) {
        Figure[][] figures = TableGenerator.generateTable(figureList);

        if (getRow() == nextColumn || getColumn() == nextColumn) {
            return true;
        }

        if (Math.abs(getRow() - nextRow) == Math.abs(getColumn() - nextColumn)) {
            return true;
        }

        if (checkDiagonalPath(figures, nextRow, nextColumn)) {
            return true;
        }

        if (checkStraightPath(figures, nextRow, nextColumn)) {
            return true;
        }

        return checkCapture(figures, nextRow, nextColumn, figureList);
    }

    private boolean checkDiagonalPath(Figure[][] board, int targetRow, int targetCol) {
        int dirRow = Integer.compare(targetRow, getRow());
        int dirCol = Integer.compare(targetCol, getColumn());

        for (int row = getRow() + dirRow, col = getColumn() + dirCol; row != targetRow; row += dirRow, col += dirCol) {
            if (board[row][col] != null) {
                return false;
            }
        }

        return true;
    }

    private boolean checkStraightPath(Figure[][] board, int targetRow, int targetCol) {
        int dirRow = Integer.compare(targetRow, getRow());
        int dirCol = Integer.compare(targetCol, getColumn());

        for (int row = getRow() + dirRow, col = getColumn() + dirCol; row != targetRow || col != targetCol; row += dirRow, col += dirCol) {
            if (board[row][col] != null) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCapture(Figure[][] board, int targetRow, int targetCol, List<Figure> figureList) {
        Figure targetFigure = board[targetRow][targetCol];
        if (targetFigure == null) {
            return false;
        }
        if (isBlack() && targetFigure.isBlack()) {
            return false;
        }
        if (isWhite() && targetFigure.isWhite()) {
            return false;
        }

        if (checkDiagonalPath(board, targetRow, targetCol) || checkStraightPath(board, targetRow, targetCol)) {
            figureList.remove(targetFigure);
            return true;
        }
        return false;
    }

    public String toString() {
        if (isSelected()) {
            return "Q";
        } else {
            return "q";
        }
    }

    public String getFigure() {
        if (isSelected()) {
            return "Q";
        } else {
            return "q";
        }
    }
}
