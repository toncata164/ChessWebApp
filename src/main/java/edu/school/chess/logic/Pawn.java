package edu.school.chess.logic;

import java.util.List;

public class Pawn extends Figure{
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
