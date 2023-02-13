package edu.school.chess.logic;

import java.util.List;

public class Knight extends Figure{
    public Knight(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
    }



    public boolean move(int row, int column, List<Figure> figureList) {
        return false;
    }
    if(isSelected() == false)
    {
        throw new Exception("You need to select the figure first!");
    }
    else if


    {
        throw new Exception("The knight can't move there!");
    }
}
