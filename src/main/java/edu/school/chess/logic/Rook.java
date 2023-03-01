package edu.school.chess.logic;

import java.util.List;

public class Rook extends Figure{

    public Rook(int row, int column, boolean figureColor){
        this(row, column, figureColor, false);
    }
    public Rook(int row, int column,boolean figureColor, boolean selected){
        super(figureColor, selected,row,column);
    }

    @Override
    protected boolean canMove(int row, int column, List<Figure> figureList) {
       Figure table[][] = TableGenerator.generateTable(figureList);

       if(table[getRow()][getColumn()] != null && table[row][column] != null
               && table[getRow()][getColumn()].getColor() == table[row][column].getColor()){
           return false;
       }else if((getRow() != row && getColumn() != column) || (getRow() == row && getColumn() == row)){
           return false;
       }
       return true;
    }

    public boolean move(int row, int column, List<Figure> figureList)  {
        Figure table[][] = TableGenerator.generateTable(figureList);
        if(!isSelected()){
            return false;
        }else {
            if (canMove(row, column, figureList) == false) {
                return false;
            } else {
                setRow(row);
                setColumn(column);
                return true;
            }
        }
    }
    public String getFigure(){
        if(isSelected()){
            return "R";
        }
        return "r";
    }
}
