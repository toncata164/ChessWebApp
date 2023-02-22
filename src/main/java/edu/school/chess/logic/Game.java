package edu.school.chess.logic;

import java.util.List;
import java.util.Optional;

public class Game implements IGame{
    private List<Figure> figures;

    public Game(){
        figures = List.of(
                new Rook(7, 0, false),
                new Knight(7, 1, false),
                new Bishop(7, 2, false),
                new Queen(7, 3, false),
                new King(7, 4, false),
                new Bishop(7, 5, false),
                new Knight(7, 6, false),
                new Rook(7, 7, false)
        );
    }

    @Override
    public void select(int row, int column) {
        Optional<Figure> figure = figures.stream().
                filter(f->f.getRow() == row && f.getColumn() == column).
                findAny();
        if(figure.isPresent()){
            figure.get().setSelected(true);
        }
    }

    @Override
    public void move(int row, int column) {
        Optional<Figure> figure = figures.stream().
                filter(f->f.isSelected()).
                findAny();
        if(figure.isPresent()){
            figure.get().move(row, column, figures);
        }
    }

    @Override
    public List<Figure> getTable() {
        return figures;
    }
}
