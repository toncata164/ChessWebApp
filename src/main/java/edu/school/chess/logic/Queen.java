package edu.school.chess.logic;

import java.util.List;

public class Queen extends Figure{
    public Queen(boolean color, boolean selected, int row, int column) {
        super(color, selected, row, column);
    }

    @Override
    protected boolean canMove(int row, int column, List<Figure> figureList) {
        int curRow=this.getRow();
        int curCol=this.getColumn();
        for(int i=curRow; i<8; i++){
            if(row==i && curCol==column){
                return true;
            }
        }
        for(int i=curRow; i>=0; i--){
            if(curRow==i && curCol==column){
                return true;
            }
        }
        for(int i=curCol; i<8; i++){
            if(column==i && curRow==row){
                return true;
            }
        }
        for(int i=curCol; i>=0; i--){
            if(column==i && curRow==row){
                return true;
            }
        }
        int k=curCol;
        for(int i=curRow; i>=0; i--){

            if(row==i && column==k){
                return true;
            }
            k--;
        }
        k=curCol;
        for(int i=curRow; i<8; i++){
            if(row==i && column==k){
                return true;
            }
            k++;
        }
        k=curCol;
        for(int i=curRow; i>=0; i--){
            if(row==i && column==k){
                return true;
            }
            k++;
        }
        k=curCol;
        for(int i=curRow; i<8; i++){
            if(row==i && column==k){
                return true;
            }
            k--;
        }
        return false;
    }

    @Override
    public boolean move(int row, int column, List<Figure> figureList) {
        if(canMove(row,column,figureList)==true){
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
