package edu.school.chess.logic;

import java.util.List;

public class Knight extends Figure{
    public Knight(int row, int column, boolean figureColor){
        this(figureColor, false, row, column);
    }
    public Knight(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
    }

    protected boolean canMove(int row, int column, List<Figure> figureList) {
        if ((row == getRow() + 2&& column == this.getColumn() + 1) ||
                (row == getRow() + 1 && column == this.getColumn() + 2) ||
                (row == getRow() - 1 && column == this.getColumn() + 2) ||
                (row == getRow() - 2 && column == this.getColumn() + 1) ||
                (row == getRow() - 2 && column == this.getColumn() - 1) ||
                (row == getRow() - 1 && column == this.getColumn() - 2) ||
                (row == getRow() + 1 && column == this.getColumn() - 2) ||
                (row == getRow() + 2 && column == this.getColumn() - 1))
        {
                return true;
    }
        {
            return false;
        }
    }
    @Override

    public boolean move(int row, int column, List<Figure> figureList) {

        if(isSelected() == false)
        {
            return false;
        }
        else{
            if(canMove(row,column,figureList)==true){
                for(int i=0; i<figureList.size(); i++){
                    if(figureList.get(i)!=this && figureList.get(i).getRow()==row && figureList.get(i).getColumn()==column){
                        if(figureList.get(i).getColor()==this.getColor()){
                            return false;
                        }
                        else{
                            setRow(row);
                            setColumn(column);
                            figureList.remove(i);
                            return true;
                        }
                    }
                }
                setRow(row);
                setColumn(column);
                return true;
            }
        }

        return false;
    }
}
