package edu.school.chess.logic;

import java.util.List;

public class Pawn extends Figure{
    private boolean hasMovedBefore=false;

    public Pawn(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
    }

    public Pawn(int row, int column, boolean color){
        this(color, false, row, column);
    }

    @Override
    public boolean move(int row, int column, List<Figure> figureList) {
        if(canMove(row,column, figureList)==true){
            setRow(row);
            setColumn(column);
            return true;
        }
        for(int i=0; i<figureList.size(); i++){
            if(figureList.get(i)!=this && figureList.get(i).getColor()!=this.getColor()){
                if(figureList.get(i).getRow()==row-1 && (figureList.get(i).getColumn()==column-1 || figureList.get(i).getColumn()==column+1)){
                    setRow(row);
                    setColumn(column);
                    figureList.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean canMove(int row, int column, List<Figure> figureList) {
        int curRow=this.getRow();
        int curCol=this.getColumn();
        if(curCol==column && curRow-1==row){
            return true;
        }
        if(hasMovedBefore==false){
            if(curCol==column && curRow-2==row){
                hasMovedBefore=true;
                return true;
            }
        }
        return false;

    }
    public String getFigure(){
        if(isSelected()){
            return "P";
        }
        return "p";
    }
}
