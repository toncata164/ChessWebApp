package edu.school.chess.logic;

import java.util.List;

public class TableGenerator {
    public static Figure[][] generateTable(List<Figure> figures){
        if(figures == null){
            throw new IllegalArgumentException("List of figures cannot be null");
        }
        final Figure[][] table = new Figure[8][8];
        figures.forEach(f->table[f.getRow()][f.getColumn()] = f);
        return table;
    }
}
