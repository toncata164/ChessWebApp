package edu.school.chess.logic;

import java.util.List;

public class Queen extends Figure
{
    public Queen(boolean color, boolean selected, int row, int column) 
    {
        super(color, selected, row, column);
    }

    public boolean move(int row, int column, List<Figure> figureList) 
    {
        if(canMove(row, column, figureList))
        {
            setRow(row);
            setColumn(column);

            return true;
        }
           
        return false;
    }
    
    protected boolean canMove(int nextRow, int nextColumn, List<Figure> figureList) 
    {
        Figure[][] figures = TableGenerator.generateTable(figureList);

        if (getRow() == nextColumn || getColumn() == nextColumn) 
        {
            return true;
        }
    
        if (Math.abs(getRow() - nextRow) == Math.abs(getColumn() - nextColumn)) 
        {
            return true;
        }
    
        if(checkDiagonalPath(figures, nextRow, nextColumn))
        {
            return true;
        }

        if(checkStraightPath(figures, nextRow, nextColumn))
        {
            return true;
        }

        return false;
    }

    private boolean checkDiagonalPath(Figure[][] board, int targetRow, int targetCol) {
        int dirRow = Integer.compare(targetRow, getRow());
        int dirCol = Integer.compare(targetCol, getColumn());
    
        for (int row = getColumn() + dirRow, col = getColumn() + dirCol; 
            row != targetRow; row += dirRow, col += dirCol) {
            if (board[row][col] != null) {
                return false; 
            } 
        }

        if(board[targetRow][targetCol].isWhite() && board[targetRow][targetCol].getColor()) //myColor is White
        {
            return false;
        }

        if(board[targetRow][targetCol].isBlack() && board[targetRow][targetCol].getColor()) //myColor is White
        {
            return false;
        }
    
        return true; 
    }

    private boolean checkStraightPath(Figure[][] board, int targetRow, int targetCol) {
        int dirRow = Integer.compare(targetRow, getRow());
        int dirCol = Integer.compare(targetCol, getColumn());
    
        for (int row = getRow() + dirRow, col = getColumn() + dirCol; row != targetRow || 
            col != targetCol; row += dirRow, col += dirCol) {
            if (board[row][col] != null) {
                return false; 
            }   
        }

        if(board[targetRow][targetCol].isWhite() && board[targetRow][targetCol].getColor()) //myColor is White
        {
            return false;
        }

        if(board[targetRow][targetCol].isBlack() && board[targetRow][targetCol].getColor()) //myColor is White
        {
            return false;
        }

        return true; 
    }
}
