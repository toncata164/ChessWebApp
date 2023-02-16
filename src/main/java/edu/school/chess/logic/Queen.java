package edu.school.chess.logic;

import java.awt.Color;
import java.util.List;

import javax.swing.text.AttributeSet.ColorAttribute;

public class Queen extends Figure
{
    public Queen(boolean color, boolean selected, int row, int column) 
    {
        super(color, selected, row, column);
    }

    public boolean move(int row, int column, List<Figure> figureList) 
    {
        Figure[][] figures = TableGenerator.generateTable(figureList);

        if(canMove(row, column, figureList) || checkDiagonalPath(figures, row, column) || checkStraightPath(figures, row, column))
        {
            setRow(row);
            setColumn(column);
        }
           
        return false;
    }
    
    protected boolean canMove(int nextRow, int nextColumn, List<Figure> figureList) 
    {
        if (getRow() == nextColumn || getColumn() == nextColumn) {
            return true;
        }
    
        if (Math.abs(getRow() - nextRow) == Math.abs(getColumn() - nextColumn)) {
            return true;
        }
    
        return false;
    }

    public static boolean checkDiagonalPath(Figure[][] board, int targetRow, int targetCol) {
        int dirRow = Integer.compare(targetRow, getRow());
        int dirCol = Integer.compare(targetCol, getColumn());
    
        for (int row = getColumn() + dirRow, col = getColumn() + dirCol; 
            row != targetRow; row += dirRow, col += dirCol) {
            if (board[row][col] != null) {
                return false; 
            } 
        }
    
        return true; 
    }

    public static boolean checkStraightPath(Figure[][] board, int targetRow, int targetCol) {
        int dirRow = Integer.compare(targetRow, getRow());
        int dirCol = Integer.compare(targetCol, getColumn());
    
        for (int row = getRow() + dirRow, col = getColumn() + dirCol; row != targetRow || 
            col != targetCol; row += dirRow, col += dirCol) {
            if (board[row][col] != null && board[row][col].getColor() == Color.BLACK) {
                return false; 
            }
        }
    
        return true; 
    }
}
