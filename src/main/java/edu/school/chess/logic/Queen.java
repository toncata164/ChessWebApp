package edu.school.chess.logic;

import java.util.List;

public class Queen extends Figure{
    @Override
    protected boolean canMove(int row, int column, List<Figure> figureList) {
        int curRow=this.getRow();
        int curCol=this.getColumn();
        for(int i=curRow; i<8; i++){
            if(curRow==i && curCol==column){
                return true;
            }
        }
        for(int i=curRow; i>=0; i--){
            if(curRow==i && curCol==column){
                return true;
            }
        }
        for(int i=curCol; i<8; i++){
            if(curCol==i && curRow==row){
                return true;
            }
        }
        for(int i=curCol; i>=0; i--){
            if(curCol==i && curRow==row){
                return true;
            }
        }
        int x=curRow+1;
        int y=curRow+1;
        while(true){
            if(x+1==8 || y+1==8){
                break;
            }
            if(x==row && y==column){
                return true;
            }
            x++;
            y++;
        }
        x=curRow+1;
        y=curCol-1;
        while(true){
            if(x+1==8 || y==0){
                break;
            }
            if(x==row && y==column){
                return true;
            }
            x++;
            y--;
        }
        x=curRow-1;
        y=curCol+1;
        while(true){
            if(x==0 || y+1==8){
                break;
            }
            if(x==row && y==column){
                return true;
            }
            x--;
            y++;
        }
        x=curRow-1;
        y=curCol-1;
        while(true){
            if(x==0 || y==0){
                break;
            }
            if(x==row && y==column){
                return true;
            }
            x--;
            y--;
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
