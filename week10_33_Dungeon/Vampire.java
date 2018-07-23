/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

public class Vampire extends Movable {

    Random randomizer;

    public Vampire(int l, int h) {
        super(l, h);
        this.randomizer = new Random();
        this.name = "v";
        this.x = this.randomizer.nextInt(length);
        this.y = this.randomizer.nextInt(height);
    }

    @Override
    public void moveVamp(int moves) {

        for (int i = 0; i < moves; i++) {
            int r = this.randomizer.nextInt(4);
            if (r == 0 && (this.y - 1) >= 0) {
                this.y--;
            } else if (r == 1 && (this.y + 1) <= this.height) {
                this.y++;
            } else if (r == 2 && (this.x - 1) >= 0) {
                this.x--;
            } else if (r == 3 && (this.x + 1) <= this.length) {
                this.x++;
            }
        }

    }

}
