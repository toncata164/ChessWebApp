package edu.school.chess.logic;

import java.util.List;

public class Knight extends Figure{
    public Knight(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
    }

    protected boolean canMove(int row, int column, List<Figure> figureList) {
        if ((row != getRow() + 2 && column != this.getColumn() + 1) &&
                (row != getRow() + 1 && column != this.getColumn() + 2) &&
                (row != getRow() - 1 && column != this.getColumn() + 2) &&
                (row != getRow() - 2 && column != this.getColumn() + 1) &&
                (row != getRow() - 2 && column != this.getColumn() - 1) &&
                (row != getRow() - 1 && column != this.getColumn() - 2) &&
                (row != getRow() + 1 && column != this.getColumn() - 2) &&
                (row != getRow() + 2 && column != this.getColumn() - 1))
        {
                return true;
    }
        {
            return false;
        }
    }
    @Override


    public boolean move(int row, int column, List<Figure> figureList) {

        if(isSelected() == false)
        {
            throw new RuntimeException("You need to select the figure first!");
        }
        else if(true)



        {
            throw new RuntimeException("The knight can't move there!");
        }

        return false;
    }
}
