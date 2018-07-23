/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;

public abstract class Movable {

    public String name;
    public int length;
    public int height;
    public int x;
    public int y;

    public Movable(int l, int h) {
        this.length = l;
        this.height = h;
    }

    public void moveHero(ArrayList<String> inputs) {
    }

    public void moveVamp(int moves) {
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "" + this.name + " " + this.x + " " + this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Movable compared = (Movable) o;
        if (this.x != compared.getX()) {
            return false;
        }
        if(this.y != compared.getY()){
            return false;
        }
        return true;
    }

}
