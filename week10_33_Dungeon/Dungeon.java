/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

    public int moves;
    public int length;
    public int height;
    public int vampires;
    public boolean vampiresMove;
    public gameTable game;
    public Players players;
    public Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.vampiresMove = vampiresMove;
        this.moves = moves;
        this.reader = new Scanner(System.in);
        this.players = new Players(vampires, length, height, vampiresMove);
        this.game = new gameTable(length, height, this.players);
    }

    public void printGame() {
        System.out.println(moves);
        System.out.println();
        System.out.println(this.players.getHero());
        this.players.printVampires();
        this.game.fillTable();
        this.game.drawTable();
        System.out.println();
    }

    public ArrayList<String> getInputs() {
        ArrayList<String> inputs = new ArrayList<String>();
        String commands = this.reader.nextLine();

        for (int i = 0; i < commands.length(); i++) {
            String c = Character.toString(commands.charAt(i));
            inputs.add(c);
        }
        return inputs;
    }

    public void run() {
        printGame();

        while (this.moves > 0) {
            
            this.players.move(this.getInputs());
            this.players.check();

            this.moves--;

            if (this.moves == 0 || this.players.getVampires().isEmpty()) {
                break;
            }

            printGame();
        }
        
        if (!this.players.getVampires().isEmpty()) {
            printGame();
            System.out.println("YOU LOSE");
        } else {
            System.out.println("YOU WIN");
        }
    }

}
