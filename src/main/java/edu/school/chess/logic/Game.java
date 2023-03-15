package edu.school.chess.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game implements IGame{
    private List<Figure> figures;

    public Game(){
        figures = new ArrayList<>(List.of(
                new Rook(7, 0, false),
                new Knight(7, 1, false),
                new Bishop(7, 2, false),
                new Queen(7, 3, false),
                new King(7, 4, false),
                new Bishop(7, 5, false),
                new Knight(7, 6, false),
                new Rook(7, 7, false),
                //new Pawn(6, 0, false),
                new Pawn(6, 1, false),
                new Pawn(6, 2, false),
                //new Pawn(6, 3, false),
                new Pawn(6, 4, false),
                new Pawn(6, 5, false),
                new Pawn(6, 6, false),
                new Pawn(6, 7, false),
                new Rook(0, 0, true),
                new Knight(0, 1, true),
                new Bishop(0, 2, true),
                new Queen(0, 3, true),
                new King(0, 4, true),
                new Bishop(0, 5, true),
                new Knight(0, 6, true),
                new Rook(0, 7, true),
                new Pawn(1, 0, true),
                new Pawn(1, 1, true),
                new Pawn(1, 2, true),
                new Pawn(1, 3, true),
                new Pawn(1, 4, true),
                new Pawn(1, 5, true),
                new Pawn(1, 6, true),
                new Pawn(1, 7, true)
        ));
    }

    @Override
    public void select(int row, int column) {
        //figures.stream().forEach(figure ->figure.setSelected(false));
        Optional<Figure> figure = figures.stream().
                filter(f->f.getRow() == row && f.getColumn() == column).
                findAny();
        if(figure.isPresent()){
            figure.get().setSelected(!figure.get().isSelected());
        }
        else{
            throw new RuntimeException("There is no figure to select!");
        }
    }

    @Override
    public void move(int row, int column) {
        Optional<Figure> figure = figures.stream().
                filter(f->f.isSelected()).
                findAny();
        if(figure.isPresent()){
            boolean hasMoved = figure.get().move(row, column, figures);
            figure.get().setSelected(!hasMoved);
            if(!hasMoved){
                throw new RuntimeException("Invalid move!");
            }
        }
        else{
            throw new RuntimeException("There is no selected figure!");
        }
    }

    @Override
    public List<Figure> getTable() {
        return figures;
    }
}
