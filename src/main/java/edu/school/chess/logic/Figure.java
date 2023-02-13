package edu.school.chess.logic;

import java.util.List;

public abstract class Figure {
    public boolean figureColor;
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
    public abstract boolean move(int row, int column, List<Figure> figureList);
}
