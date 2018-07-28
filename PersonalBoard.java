/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;


public class PersonalBoard extends GameOfLifeBoard{
    private Random random;
    
    public PersonalBoard(int width, int height) {
        super(width, height);
        random = new Random();
    }
    
    public boolean isInside(int x, int y){
        boolean inside = true;
        if(x < 0 || y < 0 || x >= getWidth() || y >= getHeight()){
            inside = false;
        }
        return inside;
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
                
        for(int i=0; i<getBoard().length; i++){
            for(int j=0; j<getBoard()[i].length; j++){
                
                double num = random.nextDouble();
                
                if(num <= probabilityForEachCell && probabilityForEachCell != 0){
                    getBoard()[i][j] = true;
                }else{
                    getBoard()[i][j] = false;
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        boolean alive = false;
        if(isInside(x,y) && getBoard()[x][y] == true){
            alive = true;
        }
        return alive;
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(isInside(x,y)){
            getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if(isInside(x,y)){
            getBoard()[x][y] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int neighbours = 0;
        
        if(isAlive(x+1, y+1)){
            neighbours++;
        }
        if(isAlive(x-1, y-1)){
            neighbours++;
        }
        if(isAlive(x+1, y-1)){
            neighbours++;
        }
        if(isAlive(x-1, y+1)){
            neighbours++;
        }
        if(isAlive(x, y-1)){
            neighbours++;
        }
        if(isAlive(x, y+1)){
            neighbours++;
        }
        if(isAlive(x-1, y)){
            neighbours++;
        }
        if(isAlive(x+1, y)){
            neighbours++;
        }
        
        return neighbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if(livingNeighbours < 2 || livingNeighbours > 3){
            turnToDead(x,y);
        }else if(isAlive(x,y) && livingNeighbours == 2 || livingNeighbours == 3){
            turnToLiving(x,y);
        }
    }
}
