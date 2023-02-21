package edu.school.chess;

import edu.school.chess.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;


public class Test {

    private static JLabel[][] board=new JLabel[8][8];
    private static int clickedX=0;
    private static int clickedY=0;


    private static Knight king=new Knight(false, true, 3,3);


    private static java.util.List<Figure> figureList=new ArrayList<Figure>();
    private static boolean oldColor=true;

    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        int x=0; int y=0;
        boolean color=true;

        for(int i=0; i<8; i++){
            for(int k=0; k<8; k++){
                JLabel j=new JLabel();
                j.setBounds(x,y,50,50);
                if(color)
                    j.setBackground(Color.WHITE);
                else{
                    j.setBackground(Color.BLACK);
                }
                color=!color;
                x+=50;
                j.setOpaque(true);
                f.add(j);
                board[i][k]=j;
                board[i][k].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        onMouseClicked(e);
                        if(king.move(clickedX,clickedY,figureList)){
                            for(int i=0; i<8; i++){
                                for(int k=0; k<8; k++){
                                    if(board[i][k].getBackground()==Color.RED){
                                        if(oldColor==true){
                                            board[i][k].setBackground(Color.WHITE);
                                        }
                                        else{
                                            board[i][k].setBackground(Color.BLACK);
                                        }
                                    }
                                }
                            }
                            if(board[clickedX][clickedY].getBackground()==Color.WHITE){
                                oldColor=true;
                            }
                            else{
                                oldColor=false;
                            }
                            board[clickedX][clickedY].setBackground(Color.RED);
                        }
                    }
                });
            }
            color=!color;
            y+=50;
            x=0;
        }

        for(int i=0; i<8; i++){
            for(int k=0; k<8; k++){
                if(i==king.getRow() && k==king.getColumn()){
                    if(board[i][k].getBackground()==Color.WHITE){
                        oldColor=true;
                    }
                    else{
                        oldColor=false;
                    }
                    board[i][k].setBackground(Color.RED);

                }
            }
        }
    }
    private static void onMouseClicked(MouseEvent e) {
        for (int i = 0; i < 8; i++){
            for (int k = 0; k < 8; k++){
                if (e.getSource() == board[i][k]) {
                    clickedX=i;
                    clickedY=k;
                }
            }
        }
    }
}
