package edu.school.chess.logic;

import java.util.List;

public abstract class Figure 
{
    public boolean figureColor;//true - black,  false - white
    public boolean selected;
    
    public int row;
    public int column;

    public void setColor(boolean newColor){
        this.figureColor=newColor;
    }
    public void setSelected(boolean newSelected){
        this.selected=newSelected;
    }
    public void setRow(int newRow){
        this.row=newRow;
    }
    public void setColumn(int newColumn){
        this.column=newColumn;
    }
    public boolean getColor(){
        return figureColor;
    }
    public boolean isSelected(){
        return selected;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public boolean isBlack(){
        return figureColor;
    }
    public boolean isWhite(){
        return !isBlack();
    }

    public Figure(boolean color, boolean selected, int row, int column){
        setColor(color);
        setSelected(selected);
        setRow(row);
        setColumn(column);
    }
    public String toString(){
        if(isSelected()==true){
            return "F";
        }
        else{
            return "f";
        }
    }

    public String getFigure(){
        return toString();
    }

    protected abstract boolean canMove(int row, int column, List<Figure> figureList);
    public abstract boolean move(int row, int column, List<Figure> figureList);
}
