package edu.school.chess.logic;

import java.util.List;

public class Rook extends Figure{

    public Rook(int row, int column,boolean figureColor, boolean selected){
        super(figureColor, selected,row,column);
    }

    public boolean move(int row, int column, List<Figure> figureList)  {
        if(!isSelected()){
            throw new Exception("The figure must be selected");
        }else if{

        }
    }
}
