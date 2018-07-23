/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.Arrays;

public class gameTable {

    public int length;
    public int height;
    public boolean vampiresMove;
    public Players players;
    public ArrayList<String> table;

    public gameTable(int l, int h, Players p) {
        this.table = new ArrayList<String>();
        this.length = l;
        this.height = h;
        this.players = p;
    }

    public void fillTable() {
        this.table.clear();
        
        for(int i=0; i<height;i++){
            ArrayList<Movable> row = new ArrayList<Movable>();
            if(this.players.getHero().getY() == i){
                row.add(this.players.getHero());
            }
            for(Vampire v:this.players.getVampires()){
                if(v.getY() == i){
                    row.add(v);
                }
            }
            
            String str = "";
            for(int j=0; j<length; j++){
                boolean occupied = false;
                
                for(Movable m:row){
                    if(m.getX()==j){
                        str+=m.getName();
                        occupied=true;
                    }
                }
                
                if(occupied == false){
                    str += ".";
                }
            }
            this.table.add(str);
        }
    }

    public void drawTable() {
        System.out.println(""); 
        for (String s : this.table) {
            System.out.println(s);
        }
        
    }

}
