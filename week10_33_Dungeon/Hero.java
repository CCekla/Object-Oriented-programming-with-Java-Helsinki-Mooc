/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;

public class Hero extends Movable {

    public Hero(int l, int h) {
        super(l, h);
        this.name = "@";
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void moveHero(ArrayList<String> inputs) {
        for (String s : inputs) {
            if (s.equals("w") && (this.y - 1) >= 0) {
                this.y--;
            } else if (s.equals("s") && (this.y + 1) < this.height) {
                this.y++;
            } else if (s.equals("a") && (this.x - 1) >= 0) {
                this.x--;
            } else if (s.equals("d") && (this.x + 1) < this.length) {
                this.x++;
            }

        }
    }

}
