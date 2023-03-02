package edu.school.chess.logic;

import java.util.List;

public interface IGame {
    void select(int row, int column);
    void move(int row, int column);

    List<Figure> getTable();
}
