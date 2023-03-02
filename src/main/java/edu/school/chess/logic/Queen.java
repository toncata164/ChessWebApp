package edu.school.chess.logic;
import java.util.List;

public class Queen extends Figure 
{
    public Queen(int row, int col, boolean color) 
    {
        this(color, false, row, col);
    }

    public Queen(boolean color, boolean selected, int row, int column)
    {
        super(color, selected, row, column);
    }

    public boolean move(int row, int column, List <Figure> figureList) 
    {
        if (canMove(row, column, figureList)) 
        {
            setRow(row);
            setColumn(column);

            return true;
        }

        return false;
    }
    
    protected boolean canMove(int nextRow, int nextColumn, List <Figure> figureList) 
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

        if(checkDiagonalPath(figures, row, column))
        {
            return true;
        }

        if(checkStraightPath(figures, row, column))
        {
            return true;
        }

        if(figures[nextRow][nextColumn].isWhite() && figures[getRow()][getColumn()].isWhite())
        {
            return false;
        }
        else if(figures[nextRow][nextColumn].isBlack() && figures[getRow()][getColumn()].isBlack())
        {
            return false;
        }
        else if((figures[nextRow][nextColumn].isBlack() && figures[getRow()][getColumn()].isWhite()) ||
                (figures[nextRow][nextColumn].isWhite() && figures[getRow()][getColumn()].isBlack()))
        {
            figureList.remove(figures[nextRow][nextColumn]);

            return true;
        }

        return false;
    }

    private boolean checkDiagonalPath(Figure[][] board, int targetRow, int targetCol) 
    {
        int dirRow = Integer.compare(targetRow, getRow());
        int dirCol = Integer.compare(targetCol, getColumn());

        for (int row = getColumn() + dirRow, col = getColumn() + dirCol; 
            row != targetRow; row += dirRow, col += dirCol) 
        {
            if (board[row][col] != null) 
            {
                return false;
            }
        }

        return true;
    }

    private boolean checkStraightPath(Figure[][] board, int targetRow, int targetCol) 
    {
        int dirRow = Integer.compare(targetRow, getRow());
        int dirCol = Integer.compare(targetCol, getColumn());

        for (int row = getRow() + dirRow, col = getColumn() + dirCol; 
            row != targetRow || col != targetCol; row += dirRow, col += dirCol) 
        {
            if (board[row][col] != null) 
            {
                return false;
            }
        }
        
        return true;
    }

    public String toString()
    {
        if(isSelected())
        {
            return "Q";
        }
        else
        {
            return "q";
        }
    }
}