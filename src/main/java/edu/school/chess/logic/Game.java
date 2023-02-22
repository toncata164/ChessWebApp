package edu.school.chess.logic;

import java.util.List;

public class Game implements IGame{
    private List<Figure> figures;

    public Game(){
        figures = List.of(
                new Rook(7, 0, false),
                new Knight(7, 1, false),
                new Bishop(7, 2, false),
                new Queen(7, 3, false),
                new King(7, 4, false),

        );
    }

    @Override
    public void select(int row, int column) {

    }

    @Override
    public void move(int row, int column) {

    }
}
