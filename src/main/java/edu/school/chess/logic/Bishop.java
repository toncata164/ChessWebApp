package edu.school.chess.logic;

import java.util.List;

public class Bishop extends Figure{
    public Bishop(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
    }

    @Override
    public boolean move(int row, int column, List<Figure> figureList) {

        return false;
    }

    @Override
    protected boolean canMove(int row, int column, List<Figure> figureList) {
        // TODO Auto-generated method stub
        return false;
    }
}
