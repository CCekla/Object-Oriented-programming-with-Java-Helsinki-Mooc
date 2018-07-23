/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;

public class Players {

    Hero hero;
    ArrayList<Vampire> vampires;
    boolean vampiresMove;

    public Players(int v, int l, int h, boolean vM) {
        this.hero = new Hero(l, h);
        this.vampires = new ArrayList<Vampire>();
        this.vampiresMove = vM;

        while (this.vampires.size() < v) {
            Vampire vamp = new Vampire(l, h);
            if (!this.vampires.contains(vamp)&& vamp.getX()!= this.hero.getX() && vamp.getX()!= this.hero.getX()) {
                vampires.add(vamp);
            }
        }
    }

    public ArrayList<Vampire> getVampires() {
        return this.vampires;
    }

    public Hero getHero() {
        return this.hero;
    }

    public void move(ArrayList<String> inputs) {
        this.hero.moveHero(inputs);
        if (vampiresMove == true) {
            for (Vampire vampire : this.vampires) {
                vampire.moveVamp(inputs.size());
            }
        }
    }

    public void check() {
        ArrayList<Vampire> killed = new ArrayList<Vampire>();
        for (Vampire vampire : this.vampires) {
            if (vampire.getX() == this.hero.getX() && vampire.getY() == this.hero.getY()) {
                killed.add(vampire);
            }
        }
        this.vampires.removeAll(killed);
    }

    public void printVampires() {
        for (Vampire v : this.vampires) {
            System.out.println(v);
        }
    }

}
