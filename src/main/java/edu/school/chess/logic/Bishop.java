package edu.school.chess.logic;

import java.util.List;

public class Bishop extends Figure{
    public Bishop(int row, int column, boolean figureColor){
        this(figureColor, false, row, column);
    }
    public Bishop(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
    }

    @Override
    protected boolean canMove(int row, int column, List<Figure> figureList) {

        return false;
    }

    @Override
    public boolean move(int row, int column, List<Figure> figureList) {

        return false;
    }

    public String getFigure(){
        if(isSelected()){
            return "B";
        }
        return "b";
    }
}
