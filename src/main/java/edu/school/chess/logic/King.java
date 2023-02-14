package edu.school.chess.logic;

import java.util.List;

public class King extends Figure{
    @Override
    protected boolean canMove(int row, int column, List<Figure> figureList) {
        if(
                        (getRow()+1==row && getColumn()+1==column) ||
                        (getRow()-1==row && getColumn()-1==column) ||
                        (getRow()+1==row && getColumn()-1==column) ||
                        (getRow()-1==row && getColumn()+1==column) ||
                        (getRow()==row && getColumn()+1==column) ||
                        (getRow()==row && getColumn()-1==column) ||
                        (getRow()+1==row && getColumn()==column) ||
                        (getRow()-1==row && getColumn()==column))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean move(int row, int column, List<Figure> figureList) {
        if(canMove(row,column,figureList)==true){

            for(int i=0; i<figureList.size(); i++){
                if(figureList.get(i)!=this) {
                    if (figureList.get(i).getColor() != this.getColor()) {
                        if (figureList.get(i).canMove(row, column, figureList) == true) {
                            return false;
                        }
                    }
                }
            }
            for(int i=0; i<figureList.size(); i++){
                if(figureList.get(i)!=this) {
                    if (figureList.get(i).getRow() == row && figureList.get(i).getColumn() == column) {
                        if (figureList.get(i).getColor() == this.getColor()) {
                            return false;
                        } else {
                            figureList.remove(i);
                            setRow(row);
                            setColumn(column);
                            return true;
                        }
                    }
                }
            }
        setRow(row);
        setColumn(column);
        return true;
        }
        return false;
    }
}
