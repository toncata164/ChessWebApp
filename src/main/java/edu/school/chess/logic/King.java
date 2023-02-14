package edu.school.chess.logic;

import java.util.List;

public class King extends Figure{
    @Override
    public boolean move(int row, int column, List<Figure> figureList) {
        if(
                (getRow()+1==row && getColumn()+1==column) ||
                (getRow()-1==row && getColumn()-1==column) ||
                (getRow()+1==row && getColumn()-1==column) ||
                (getRow()-1==row && getColumn()+1==column) ||
                (getRow()==row && getColumn()+1==column) ||
                (getRow()==row && getColumn()-1==column) ||
                (getRow()+1==row && getColumn()==column) ||
                (getRow()-1==row && getColumn()==column))
        {
        setRow(row);
        setColumn(column);
        return true;
        }
        return false;
    }
}
