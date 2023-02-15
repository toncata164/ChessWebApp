package edu.school.chess.logic;

import java.util.List;

public class Pawn extends Figure{
    private boolean hasAlreadyMoved;
    public Pawn(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
        hasAlreadyMoved = false;
    }

    private boolean lastRowReached(){
        return (isBlack() && getRow() == 7) || (!isBlack() && getRow() == 0);
    }

    @Override
    protected boolean canMove(int row, int column, List<Figure> figureList) {
        Figure[][] figures = TableGenerator.generateTable(figureList);
        if(hasAlreadyMoved){
            //if move forward without eating opponent's figure
            if(column == getColumn()){
                //if figure is black, move is down and field is empty
                if(isBlack() && row == getRow()+1 && figures[row][column] == null){
                    return true;
                }
                //if figure is white, move is up and field is empty
                if(!isBlack() && row == getRow()-1 && figures[row][column] == null){
                    return true;
                }
                return false;
            }
            //if move diagonally eating opponent's figure
            else if(Math.abs(column - getColumn()) == 1){
                if(figures[row][column] == null){
                    return false;
                }
                if(isBlack() && figures[row][column].isBlack()){
                    return false;
                }
                if(isWhite() && figures[row][column].isWhite()){
                    return false;
                }
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public boolean move(int row, int column, List<Figure> figureList) {
        if(!canMove(row, column, figureList)){
            return false;
        }
        setRow(row);
        setColumn(column);
        //if there is a figure we shoud eat it
        Figure toEat = TableGenerator.generateTable(figureList)[row][column];
        if(toEat != null){
            figureList.remove(toEat);
        }
        if(lastRowReached()){
            //change the Figure at this position
        }
        hasAlreadyMoved = true;
        return true;
    }
}
