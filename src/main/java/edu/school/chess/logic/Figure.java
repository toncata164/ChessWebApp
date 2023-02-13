package edu.school.chess.logic;

import java.util.List;

public abstract class Figure {
    //color
    //selected
    //row
    //column
    public abstract boolean move(int row, int column, List<Figure> figureList);
}
