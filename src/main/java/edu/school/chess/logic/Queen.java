package edu.school.chess.logic;

import java.util.List;

public class Queen extends Figure{
    @Override
    public boolean move(int row, int column, List<Figure> figureList) {
        return false;
    }
}
